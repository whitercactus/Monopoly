package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean playing = true;

        while (playing){
            System.out.println("How many players?");
            Scanner input = new Scanner(System.in);
            int numPlayers = input.nextInt();

            Game g = new Game(numPlayers);
            g.play();

            System.out.println("Play again?");
            Scanner input2 = new Scanner(System.in);
            String playAgain = input2.nextLine();

            if (playAgain == "no") {
                playing = false;
            }
        }
    }
}
