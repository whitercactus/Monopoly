package com.company;

public class Property {
    private final String name;
    private final int value;
    private final int rent;
    private Player owner;

    public Property(String name, int value, int rent) {
        this.name = name;
        this.value = value;
        this.rent = rent;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getRent() {
        return rent;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player player) {
        this.owner = player;
    }

    public boolean isOwned() {
        return this.owner != null;
    }
}
