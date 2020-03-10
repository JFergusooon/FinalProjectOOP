package models;

import java.util.Random;

public class Human implements IAttackable {
    protected String name;
    protected int health;
    protected int currentHealth;
    protected boolean isAlive = true;
    static Random rng = new Random();

    public Human(String name, int health, boolean isAlive) {
        setName(name);
        setHealth(health);
        setAlive(isAlive);
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

    public int getCurrentHealth() {

        return currentHealth;

    }

    public void setCurrentHealth(int currentHealth) {
        if(currentHealth>health) {
            this.currentHealth = health;
        }
        else{
            this.currentHealth = currentHealth;
        }
    }

    public void setAlive(boolean alive) {
        if (currentHealth > 0){
            isAlive = alive;
        }
        else{

        }
    }

    public boolean isAlive() {

        if(currentHealth < 0){
            isAlive = false;
        }
        else isAlive = true;
        return isAlive;
    }


    public int roll(int max, int amountOfRolls){
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
        //rolls 1, 10-sided die for accuracy
        //rolls 2, 6 sided dice for damage
         int damage = 0;
        //If roll is 1-3 attack misses
        if(rollAccuracy>=1 && rollAccuracy <= 3){
            damage = 0;
        }
        //If roll is 4-8 attack hits
        else if(rollAccuracy>= 4 && rollAccuracy<=8){
            damage = rollDamage;
        }
        //If roll is 9-10 attack is critical
        else if(rollAccuracy>=9 && rollAccuracy<=10){
            damage = (rollDamage)*2;
        }
        return damage;
    }

    public int takeDamage(boolean isBlocking) {
        int attackPower = attack(roll(10, 1), roll(6, 2));
        if(isBlocking){
            attackPower = attackPower/3;
            setCurrentHealth(getCurrentHealth() - (attackPower));
        }
        setCurrentHealth(getCurrentHealth() - attackPower);

        return attackPower;
    }
}
