package com.example.baseball;

import java.util.Random;

public class BaseballGame {
    private static final int MAX_NUMBER = 9;

    public BaseballGame() {

    }

    public void start() {

    }

    public int[] getRandomNumbers() {
        Random r = new Random();

        int firstNumber = r.nextInt(MAX_NUMBER) + 1;
        int secondNumber = getSecondRandomNumber(r, firstNumber);
        int thirdNumber = getThirdRandomNumber(r, firstNumber, secondNumber);

        return new int[] {firstNumber, secondNumber, thirdNumber};
    }

    public int getSecondRandomNumber(Random r, int firstNumber) {
        int secondNumber;

        do {
            secondNumber = r.nextInt(MAX_NUMBER) + 1;
        } while (firstNumber == secondNumber);

        return secondNumber;
    }

    public int getThirdRandomNumber(Random r, int firstNumber, int secondNumber) {
        int thirdNumber;

        do {
            thirdNumber = r.nextInt(MAX_NUMBER) + 1;
        } while (firstNumber == thirdNumber || secondNumber == thirdNumber);

        return thirdNumber;
    }
}
