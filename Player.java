package com.company;

public class Player {
    private final String name;
    private int totalcash;
    private int position;
    public Player(String name, int totalcash) {
        this.name = name;
        this.totalcash = totalcash;
    }

    public String getName() {
        return name;
    }

    public void addcash(int amount) {
        totalcash += amount;
    }

    public void removecash(int amount) {
        totalcash -= amount;
    }

    public int getTotalcash() {
        return totalcash;
    }

    public int getPosition() {
        return position;
    }

    public boolean isBankrupt() {
        return this.totalcash <= 0;
    }

    public void move(int numberOfSquares) {
        // it's basicly counting how much you move. The remainder gives you the answer.
        this.position += numberOfSquares;
        this.position = this.position % GameBoard.NUMBER_OF_PROPERTIES;
    }
}

