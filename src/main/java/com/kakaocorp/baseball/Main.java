package com.kakaocorp.baseball;

public class Main {
    private static BullsAndCows bullsAndCowsGame;

    public static void main(String[] args) {
        bullsAndCowsGame = new BullsAndCows();

        bullsAndCowsGame.start();
    }
}
