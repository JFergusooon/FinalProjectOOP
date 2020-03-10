package controllers;

import lib.ConsoleIO;
import models.Human;
import models.Npc;
import models.Player;
import utility.RNG;

public class Battle {
    public void battleRun(Player player, Npc npc){
        initialize(player,npc);
        String[] options = {"1) Attack", "2) Block"};
        boolean battleOver = false;
        int playerChoice =0;
        do{

            System.out.println(player.getName() + ": " + player.getCurrentHealth());
            System.out.println(npc.getName() + ": " + npc.getCurrentHealth());
          playerChoice = ConsoleIO.promptForMenuSelection(options,false);
          switch (playerChoice){
              case 1:
                  attackNPC(npc);
                  takeDamage(player, false);
                  break;
              case 2:
                  takeDamage(player, true);
          }

            battleOver = checkWin(player, npc);
        }while (!battleOver);
    }
    public void initialize(Player player, Npc npc){
        player.setCurrentHealth(100);
        npc.setCurrentHealth(75);
    }

    public boolean checkWin(Player player, Npc npc){
        if(!(npc.isAlive())){
            System.out.println("You knocked "+ npc.getName() + " out!");
            return true;
        }
        else if(!(player.isAlive())){
            System.out.println("You got knocked the hell out!");
            return true;
        }
        return false;
    }
    public int takeDamage(Human currentPlayer, boolean isBlocking){
        int damage = currentPlayer.takeDamage(isBlocking);
        System.out.println(currentPlayer.getName() + " took " + damage + " damage.");
        return damage;

    }
    public void attackNPC(Npc npc){
        int decision = RNG.getRandomInt(0,1);
        switch (decision){
            case 0:
                takeDamage(npc, false);
                break;
            case 1:
                takeDamage(npc, true);
                break;
            default:
                break;
        }

    }
}
