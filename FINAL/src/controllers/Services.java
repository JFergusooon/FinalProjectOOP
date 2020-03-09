package controllers;

import lib.ConsoleIO;
import models.Human;
import models.Player;


public class Services {
    private static int classPeriod = 0;
    public static Player user;
    private static String[] classes = {"Math, Gym, Science, Chemistry, English, History, Geography, Library"};
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
    private static String lunchroomString = "Lunchroom";
    private static String lunchroomDescription = "Finally, lunch time! You sit down alone and start eating a yummy chicken " +
            "pot pie. As you eat you \nlook around the noisy lunchroom, the walls are very tall and have banners on them of " +
            "all the neighboring \nschools in the same district. Your school is the bull.";

    public static void userMakeChoice(){
        boolean userChoice = ConsoleIO.promptForBoolean("What will you do? (option 1 or 2)", "1", "2");
        if(userChoice == false){
            user.setReputation(user.getReputation() - 4);
        }
        else{
            user.setReputation(user.getReputation() + 4);
        }
    }

    public static void run() {
        System.out.println("Welcome to the Jock!");
        startMenu();
    }
    public static void gameMethod() {
        String openingScene = ("You just joined a new school, supposedly the toughest school around, Bullworth Academy. " +
                "Today is your first day! Your mother\ndrops you off at the door and you walk inside. The school looks " +
                "very nice and open, kids scrambled around talking to \none another. You start to stand out because everyone " +
                "seems to have a uniform on whereas you only have \na sweater on with jeans. You walk to the principal’s " +
                "office. \n\nAfter 15 minutes of him telling you to have a clean nose you get your uniform walk to the bathroom" +
                " to change....will you put on the uniform?\n(y/n)");
        System.out.println(openingScene);
        userMakeChoice();

    }


    public static void startMenu() {
        String[] options = {"New Game", "Load Game"};
        int choice = ConsoleIO.promptForMenuSelection(options, true);

        switch(choice) {
            case 1:
                newGameMenu();
            case 2:
                loadGameMenu();
        }
    }

    public static void newGameMenu() {
        String userName = ConsoleIO.promptForString("Enter Character's name: ");
        user = new Player(userName, 100, 0);
        System.out.println("Character Created.");

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
