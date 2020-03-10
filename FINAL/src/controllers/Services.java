package controllers;

import lib.ConsoleIO;
import models.Human;
import models.Npc;
import models.Player;

import java.util.ArrayList;
import java.util.Random;


public class Services {
    static Random rng = new Random();
    private static int classPeriod = 0;
    public static Player user = new Player("DEFAULT", 100, true);
    private static ArrayList<String> classes = new ArrayList<>();//"Math, Gym, Science, Chemistry, English, History, Geography, Library");

    static NpcController normy1Controller = new NpcController();
    static Battle battle = new Battle();
    static Npc bully1 = new Npc("Bully", 75, true);
    static Npc normy1 = new Npc("Some Kid", 50, true);
    static Npc principal = new Npc("Principal", 150, true);

    private static String[] classDescriptions = {"Walking into the class they call Trigonometry. Math has always been easy " +
            "for you, you have a natural talent for most subjects \nin school, the only real factor is if you can " +
            "keep yourself out of trouble. You take your seat.",
            "The gym room smells like your average boy’s locker room, sweat and socks. This place feels like a danger zone. " +
                    "You didn’t bring any clothes \nto change into so your standing out again.” There are three rows of lockers " +
                    "and three different showers\n with many stalls.",
            "Earth sciences, a classroom full of science posters and hanging planets and small, old desks. The carpet looks" +
                    " very old and so does the teacher.\nYou find a vacant seat in the back and walk towards it…",
            "This would be one of your hardest subjects, chemistry. This looks like the biggest classroom yet, tons of table " +
                    "and sinks and \nmany plastic bins with who knows what kind of equipment. Instead of individual desks, " +
                    "there are groups of tables pushed \ntogether, great now you’re going to HAVE to work with others.",
            "Walking into the English class you found always to be somewhat comforting. English is such an easy class to" +
                    " pass with a good grade. \nThe walls are so white and full of light from the many windows. There are a " +
                    "few bookshelves and many \nnew desks to sit in.",
            "History! Your favorite subject in school. The classroom is somewhat darker than the others, less windows. Tons" +
                    " of old books containing \ngracious amounts of knowledge if you had the time to read them all. The desks" +
                    " are old and organized into \nrows that don’t seem to be so straight. The teacher’s desk is in the back.",
            "This classroom feels very plain but also new. More of a round looking room with the desks being in the center." +
                    " There are many maps that \ncan be pulled down that go over the white boards. The teacher looks very fat " +
                    "but also kind.",
            "The quietest place in the building, the library. Many bookshelves that are covered in dust. Not many use them" +
                    " now because of the internet.\nThere are some computers, mostly likely used for gaming. Some of the schools" +
                    " artists display their stuff \nhere for the few people to see that come here."};
    private static String lunchroomDescription = "Finally, lunch time! You sit down alone and start eating a yummy chicken " +
            "pot pie. As you eat you \nlook around the noisy lunchroom, the walls are very tall and have banners on them of " +
            "all the neighboring \nschools in the same district. Your school is the bull.";

    public static void run() {
        classes.add("Math");
        classes.add("Gym");
        classes.add("Science");
        classes.add("Chemistry");
        classes.add("English");
        classes.add("History");
        classes.add("Geography");
        classes.add("Library");

        System.out.println("Welcome to the Jock!");
        startMenu();
    }

    public static void userMakeChoice(){
        boolean userChoice = ConsoleIO.promptForBoolean("What will you do? (option 1 or 2)", "1", "2");
        if(userChoice == false){
            user.setReputation(user.getReputation() - 4);
            System.out.println("(-4 rep) "+ "Your current rep "+ user.getReputation() +"\n\n");
        }
        else{
            user.setReputation(user.getReputation() + 4);
            System.out.println("(+4 rep) "+ "Your current rep "+ user.getReputation() +"\n\n");
        }
    }

    public static void postFightCheck(Player player, Npc npc){
        if(player.isAlive()){
            player.setReputation(player.getReputation()+2);
            System.out.println("You beat the "+npc.getName()+" to a pulp. (+2 rep) "+ "Your current rep "+ user.getReputation() +"\n\n");
        }
        else {
            player.setReputation(player.getReputation()-3);
            System.out.println("You got knocked out! (-3 rep) "+"Your current rep "+ user.getReputation() +"\n\n");
        }
    }

    public static void getRandomInteraction(){
        int rolledNum = rng.nextInt((2 - 0) + 1 ) + 0;
        switch (rolledNum) {
            case 0:
                System.out.println("Some kid approaches you...");
                if(normy1Controller.protectNPC(user)) {
                    battle.battleRun(user, bully1);
                    postFightCheck(user, bully1);
                }
                break;
            case 1:
                int rolledNum1 = rng.nextInt((1-0)+1)+0;
                switch (rolledNum1){
                    case 0:
                        System.out.println("Some girl walks up to you, looks like she may ask you for a favor...");
                        break;
                    case 1:
                        System.out.println("Some guy approaches you, looks like he may ask something of you...");
                        break;
                }
                if(normy1Controller.helpNPC(user)){
                    user.setReputation(user.getReputation() + 4);
                    System.out.println("(+4 rep) "+ "Your current rep "+ user.getReputation() +"\n\n");
                }
                else{
                    user.setReputation(user.getReputation()-4);
                    System.out.println("(-4 rep) "+ "Your current rep "+ user.getReputation() +"\n\n");
                }
                break;
            case 2:
                System.out.println("Looks like a bully is approaching...");
                if(normy1Controller.fightBully(user)){
                    battle.battleRun(user, bully1);
                    postFightCheck(user, bully1);
            }
            else{
                System.out.println("You escaped the bully, for now...You make it t your next class.");
                user.setReputation(user.getReputation()+4);
                System.out.println("(+0 rep) "+ "Your current rep "+ user.getReputation() +"\n\n");
            }
                break;
        }
    }

    public static void getRandomClass(){
        classPeriod++;
        String currentClassRoom;
        int max = classes.size() - 1;
        int min = 0;
        int rolledNum = rng.nextInt((max-min)+1)+min;

        if(classPeriod == 5){
            System.out.println(lunchroomDescription +"\n");
        }else {
            currentClassRoom = classes.get(rolledNum);
            System.out.println("Next Class: " + currentClassRoom);
            System.out.println(classDescriptions[rolledNum] + "\n");
            classes.remove(rolledNum);
            getRandomInteraction();
        }
    }

    public static void gameMethod() {
        String openingScene = ("You just joined a new school, supposedly the toughest school around, Bullworth Academy. " +
                "Today is your first day! Your mother\ndrops you off at the door and you walk inside. The school looks " +
                "very nice and open, kids scrambled around talking to \none another. You start to stand out because everyone " +
                "seems to have a uniform on whereas you only have \na sweater on with jeans. You walk to the principal’s " +
                "office. \n\nAfter 15 minutes of him telling you to have a clean nose, you get your uniform and walk to the " +
                "bathroom to change....will you put on the uniform?\n(y/n)");
        System.out.println(openingScene);
        userMakeChoice();
        for(int i = 0; i < 9; i++) {
            getRandomClass();
        }
        checkForEnding();
        System.out.println("The End!");
    }

    public static void checkForEnding(){
        if(user.getReputation() < 0){
            battle.battleRun(user, principal);
            postFightCheck(user, principal);
            System.out.println("You have become the Ultimate Jock, even if you lost a fight. All Jocks loose some battles.\n\n");
        }
        else {
            System.out.println("You graduated the toughest school in the US! You are the finest student yet! \n\n");
        }
    }

    public static void startMenu() {
        String[] options = {"New Game", "Load Game"};
        int choice = ConsoleIO.promptForMenuSelection(options, true);

        switch(choice) {
            case 1:
                newGameMenu();
                break;
            case 2:
                loadGameMenu();
                break;
        }
    }

    public static void newGameMenu() {
        String userName = ConsoleIO.promptForString("Enter Character's name: ");
        System.out.println("Character Created.");
        user.setName(userName);
        String[] options = {"Go To School", "Change Name"};
        int choice = ConsoleIO.promptForMenuSelection(options, true);

        switch(choice) {
            case 1:
                gameMethod();
                break;
            case 2:
                String newName = ConsoleIO.promptForString("Enter " + user.getName() + "'s New Name: ");
                user.setName(newName);
                gameMethod();
                break;
        }
    }

    public static void loadGameMenu() {
        String loadKey = ConsoleIO.promptForString("Enter Your Character's Name: ");
        gameMethod();
    }
}
