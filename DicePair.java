package com.company;

public class DicePair {
    private Dice A = new Dice();
    private Dice B = new Dice();

    public int throwOnce() {
        return A.throwOnce() + B.throwOnce();
    }
}
