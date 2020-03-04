package models;

public class Npc extends Human{

    public Npc(String name, int health) {
        super(name, health);
    }

    public String interaction(){
        //TODO make texts based on npc type
        return null;
    }

}