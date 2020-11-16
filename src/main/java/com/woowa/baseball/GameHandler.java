package com.woowa.baseball;

import java.util.ArrayList;
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
        ArrayList<String> result = new ArrayList<>();
        String number = getRandomNumber();
        while (result.size() < 3) {
            addNumber(result, number);
            number = getRandomNumber();
        }
        return changeListToString(result);
    }

    public ArrayList<String> addNumber(ArrayList<String> array, String number) {
        if (array.contains(number)) {//check duplicated number
            return array;
        }
        array.add(number);
        return array;
    }

    public String getRandomNumber() {
        Random rand = new Random();
        int upperbound = 9;//generate random values from 0-8
        int int_random = rand.nextInt(upperbound);
        int_random++;//make random value 1-9
        return Integer.toString(int_random);
    }

    public String changeListToString(ArrayList<String> input) {
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (result.length() < input.size()) {
            result.append(input.get(i++));
        }
        return result.toString();
    }

}
