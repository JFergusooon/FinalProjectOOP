package models;

public class NPC extends Human{

    public NPC(String name, int health) {
        super(name, health);
    }

    public String interaction(){
        //TODO make texts based on npc type
        return null;
    }

}