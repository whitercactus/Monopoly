package com.company;

import java.util.Random;

public class Dice {
    private static final Random rnd = new Random();

    public int throwOnce() {
        // This selects a random number between 0-5. Then it adds 1 to make it a number between 1 and  6.
        return Math.abs(rnd.nextInt() % 6) + 1;
    }
}
