package controller;

import domain.RandomNumber;

import java.util.List;

public class GameMain {
    public static final int RESET_GAME = 1;

    public static void main(String[] args) {
        int reset = RESET_GAME;
        while (reset == RESET_GAME) {
            final List<Integer> randomNumber = RandomNumber.createRandomNumber();

            reset = BaseBall.baseBallGame(randomNumber);
        }
    }


}
