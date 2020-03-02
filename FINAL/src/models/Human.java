package models;

import java.util.Random;

public class Human implements IAttackable {
    protected String name;
    protected int health;
    static Random rng = new Random();

    public Human(String name, int health) {
        setName(name);
        setHealth(health);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    private int roll(int max, int amountOfRolls){
                int rolledNum;
                int endResult = 0;
                final int min = 1;

                for(int i = 0 ; i < amountOfRolls; i++){
                    rolledNum = rng.nextInt((max-min)+1)+min;
                    endResult = rolledNum+ endResult;
                }
            return endResult;
    }
    @Override

    public int attack(int rollAccuracy , int rollDamage) {
        //rolls 1, 10-sided die
        int accuracy = rollAccuracy;
        int damage = 0;
        //If roll is 1-3 attack misses
        if(accuracy>=1 && accuracy <= 3){
            damage = 0;
        }
        //If roll is 4-8 attack hits
        else if(accuracy>= 4 && accuracy<=8){
            damage = rollDamage;
        }
        //If roll is 9-10 attack is critical
        else if(accuracy>=9 && accuracy<=10){
            damage = (rollDamage)*2;
        }
        return damage;
    }
}
