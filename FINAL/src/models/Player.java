package models;

public class Player extends Human {
    private int reputation = 0;
    private String[][] inventory;

    public Player(String name, int health) {
        super(name, health);
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public String[][] getInventory() {
        return inventory;
    }

    public void setInventory(String[][] inventory) {
        this.inventory = inventory;
    }

}
