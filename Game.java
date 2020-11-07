package com.company;

import java.util.Scanner;

public class Game {

    private DicePair dicePair = new DicePair();

    private final Player[] players;

    private GameBoard gameboard = new GameBoard();

    private int roundNumber;

    public Game(int numberOfPlayers) {
        this.players = new Player[numberOfPlayers];

        // Create numberOfPlayers players.
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player("Player " + i, 15000000);
        }
    }

    public void play() {
        while (true) {
            playRound();
        }
    }

    private void playRound() {
        roundNumber++;

        System.out.println("---------- Round " + roundNumber + "----------");
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + i + " has " + players[i].getTotalcash() + "$ left.");
        }

        // Look at all of the players.
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];

            // Make sure only non-bankrupt players get to play.
            if (!player.isBankrupt()) {
                Scanner input = new Scanner(System.in);
                String in = input.nextLine();
                playTurn(player);
            } else {
                System.out.println(player.getName() + " is bankrupt so he won't be playing for this round");
            }
        }
    }

    private void playTurn(Player player) {
        // Throw the dice and move the player forward by that amount.
        int value = dicePair.throwOnce();
        player.move(value);

        System.out.println(player.getName() + " moved rolled the dice and got " + value);
        Property property = gameboard.getPropertyAt(player.getPosition());

        // If the property is owned, the player needs to pay rent. Otherwise, if he has enough money, he
        // automatically purchases the property.
        if (!property.isOwned()) {
            if (player.getTotalcash() >= property.getValue()) {
                System.out.println("Player" + player.getName() + "just purchased " + property.getName());
                player.removecash(property.getValue());
                property.setOwner(player);
            } else {
                System.out.println(player.getName() +
                        " can't afford to buy " + property.getName() +
                        " it is worth " + property.getValue() + " and he only has " +
                        player.getTotalcash() + "$ left");
            }
        } else if (property.getOwner() != player) {
            System.out.println(player.getName() + " fell on a property that is owned by " + property.getOwner().getName());
            System.out.println("He will need to pay " + property.getRent() + "$ to the owner.");
            player.removecash(property.getRent());
            property.getOwner().addcash(property.getRent());
        } else {
            System.out.println(player.getName() + " fell on " + property.getName() + " and he already owns it. Doing nothing.");
        }

        if (player.isBankrupt()) {
            System.out.println(player.getName() + " is bankrupt.");

            // Look at all the properties. Then, for each property that belongs to the bankrupt player,
            // make the owner null. That way, players can purchase it.
            for (int i = 0; i < GameBoard.NUMBER_OF_PROPERTIES; i++) {
                Property currentProperty = gameboard.getPropertyAt(i);
                if (currentProperty.getOwner() == player) {
                    currentProperty.setOwner(null);
                }
            }

            if (isGameOver()) {
                endGame();
            }
        }
    }

    private int countNumberOfBankrupties() {
        int total = 0;

        for (int i = 0; i < this.players.length; i++) {
            if (players[i].isBankrupt()) {
                total++;
            }
        }

        return total;
    }

    private Player findWinner() {
        for (int i = 0; i< this.players.length; i++) {
            if (!players[i].isBankrupt()) {
                return players[i];
            }
        }

        return null;
    }

    private boolean isGameOver() {
        return countNumberOfBankrupties() >= this.players.length - 1;
    }

    private void endGame() {
        Player winner = findWinner();
        System.out.println(winner.getName() + " wins!");
        System.exit(1);
    }
}

