package controllers;

import lib.ConsoleIO;
import models.Human;




public class Services {
    private static int classPeriod = 0;
    public static Human user;


    public static void run() {
        System.out.println("Welcome to Bully!");
        mainMenu();
    }
    public static void GameMethod() {

    }












    //-----------------------------------------------------------------------------------
    public static void mainMenu() {
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
        user = new Human(userName, 100, true);
        System.out.println("Character Created.");

        String[] options = {"Go To School", "Change Name"};
        int choice = ConsoleIO.promptForMenuSelection(options, true);

        switch(choice) {
            case 1:
                GameMethod();
                break;
            case 2:
                String newName = ConsoleIO.promptForString("Enter " + user.getName() + "'s New Name: ");
                user.setName(newName);
                break;
        }
    }

    public static void loadGameMenu() {
        String loadKey = ConsoleIO.promptForString("Enter Your Character's Name: ");
    }
}
