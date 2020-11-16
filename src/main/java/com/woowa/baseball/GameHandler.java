package com.woowa.baseball;

import java.util.Random;

public class GameHandler {

    GameIO io;
    Referee referee;

    public GameHandler() {
        io = new GameIO();
        referee = new Referee(getThreeNumber());
    }

    public String playGame() {
        referee.setNumber(getThreeNumber());
        doGame();
        return io.inputFromUser();
    }

    public String playGame(String number) {
        referee.setNumber(number);
        doGame();
        return io.inputFromUser();
    }

    private void doGame() {
        boolean isOut = false;
        while (!isOut) {
            io.printInputNumber();
            String inputNumber = io.inputFromUser();
            int strike = referee.checkStrike(inputNumber);
            int ball = referee.checkBall(inputNumber);
            io.printStrikeBall(strike, ball);
            isOut = referee.checkGameOut(strike);
            io.printEndGame(strike);
        }
    }

    public String getThreeNumber() {
        StringBuilder result = new StringBuilder();
        while (result.length() < 3) {
            result.append(getRandomNumber());
        }
        return result.toString();
    }

    public String getRandomNumber() {
        Random rand = new Random();
        int upperbound = 9;//generate random values from 0-8
        int int_random = rand.nextInt(upperbound);
        int_random++;
        return Integer.toString(int_random);
    }

}
