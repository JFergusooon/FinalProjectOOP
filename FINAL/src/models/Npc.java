package models;

public class Npc extends Human{




    public Npc(String name, int health, boolean isAlive) {
        super(name, health, isAlive);

    }

    public String interaction(){
        //TODO make texts based on npc type
        return null;
    }

}