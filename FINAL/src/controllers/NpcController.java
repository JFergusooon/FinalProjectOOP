package controllers;

        import lib.ConsoleIO;
        import models.*;
        import utility.RNG;

        import java.util.Random;

public class NpcController {

    public static boolean helpNPC(Player player){
        int randomPrompt = RNG.getRandomInt(0,1);
        String[] askForPen = {"Hey " +player.getName()+ ", lend me a pen will ye\'? (y/n) ",
                "New kid, I need a pencil (y/n) ",
                player.getName() +" , I need to borrow a pen. (y/n) ",
                "I lost my pen, would you be so kind as to lend me one? (y/n) "};
        String[] askForHelp= {"Hey "+ player.getName() +", can you help me out with this? (y/n) ",
                player.getName() +" I need to ask you a question about this assignment. (y/n) ",
                player.getName() +" can you help me? (y/n) ",
                "This assignment sucks ass, can you help me out for a sec? (y/n) "};
        int randomPenText=RNG.getRandomInt(0,askForPen.length-1);
        int randomHelpText = RNG.getRandomInt(0,askForHelp.length-1);
        boolean isHelping = false;

        switch (randomPrompt){
            case 0:
                isHelping = ConsoleIO.promptForBoolean(askForPen[randomPenText], "Y","N");
                break;
            case 1:
                isHelping = ConsoleIO.promptForBoolean(askForHelp[randomHelpText],"Y", "N");
                break;
            default:
        }

        return isHelping;
    }

    public static boolean protectNPC(Player player){
        String[] askForProtection = {"I think some kids wanna beat me up, can you sit by me for a bit? (y/n) ",
                "There are some kids that are planning to mug me, can you help me out? (y/n) ",
                "Those kids over there are wanting to beat us up I overheard them saying, can we stick together for a bit? (y/n) ",
                player.getName() + " is your name right? Can you protect me for a while? Some kids are waiting for me and I don’t want to be alone? (y/n) "};
        int randomProtectText = RNG.getRandomInt(0, askForProtection.length-1);
        boolean isProtecting = false;

        isProtecting = ConsoleIO.promptForBoolean(askForProtection[randomProtectText], "Y", "N");

        return isProtecting;
    }

    public static boolean fightBully(Player player){
        int randomPrompt = RNG.getRandomInt(0,1);

        String[] provokingDialogue = {"You look like you wanna punch me right now, why don’t you huh? (Fight/Run) ",
                "Get over here so I can be the shit out of you new kid. (Fight/Run) ",
                "You gonna fight? (y/n) ",
                "Yo "+ player.getName() + ", lets settle this like men do back east. (Fight/Run) "};
        String[] takeLunchMoneyDialogue = {"I will be taking you lunch money for the next couple days. (Fight/Run) ",
                "Give me some money so I can go buy some milk you f**. (Fight/Run) ",
                "If you give your money to me I wont knock your teeth out. (Fight/Run) "};
        int randomProvokeText = RNG.getRandomInt(0,provokingDialogue.length-1 );
        int randomLunchText = RNG.getRandomInt(0, takeLunchMoneyDialogue.length-1);
        boolean isFighting = false;
        switch(randomPrompt){
            case 0:
                isFighting = ConsoleIO.promptForBoolean(provokingDialogue[randomProvokeText], "Fight", "Run");
                break;
            case 1:
                isFighting = ConsoleIO.promptForBoolean(takeLunchMoneyDialogue[randomLunchText], "Fight", "Run");
                break;
        }

        return isFighting;
    }
}
