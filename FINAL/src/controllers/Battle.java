package controllers;

import lib.ConsoleIO;
import models.Human;
import models.Npc;
import models.Player;

public class Battle {

    public void battleRun(Player player, Npc npc){
        initialize(player,npc);

        String[] options = {"1) Attack", "2) Block"};
        boolean battleOver = false;
        int playerChoice =0;
        int playerDamage;
        int npcDamage;
        do{
            playerDamage = attack(player);
            npcDamage = attack(npc);
            System.out.println(player.getName() + ": " + player.getCurrentHealth());
            System.out.println(npc.getName() + ": " + npc.getCurrentHealth());
          playerChoice = ConsoleIO.promptForMenuSelection(options,false);
          switch (playerChoice){
              case 1:
                  System.out.println(player.getName()+" did " + playerDamage + " damage");
                  npc.setCurrentHealth(npc.getCurrentHealth() - playerDamage);

                  break;
              case 2:
                  npcDamage = npcDamage/2;
          }

            System.out.println(npc.getName()+" did " + npcDamage + " damage");
            player.setCurrentHealth(player.getCurrentHealth()-npcDamage);

            battleOver = checkWin(player, npc);


        }while (!battleOver);
    }
    public void initialize(Player player, Npc npc){
        player.setCurrentHealth(100);
        npc.setCurrentHealth(100);
    }
    public int attack(Human human){
        int damage = human.attack(human.roll(10,1),human.roll(6,2));
       return damage;
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

}
