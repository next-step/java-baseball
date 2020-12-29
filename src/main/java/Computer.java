import Model.GuessResult;

import java.util.ArrayList;
import java.util.Random;

public class Computer {
    static final int NUMBER_OF_DIGIT = 3;
    static final int MAX_NUMBER = 9;
    static final int MIN_NUMBER = 1;

    private ArrayList<Integer> hiddenNumbers = new ArrayList<Integer>();

    public ArrayList<Integer> getHiddenNumbers() {
        return hiddenNumbers;
    }

    public void setHiddenNumbers(ArrayList<Integer> hiddenNumbers) {
        this.hiddenNumbers = hiddenNumbers;
    }

    public void selectRandomNumber() {
        Random random = new Random();
        random.setSeed(System.nanoTime());

        hiddenNumbers.clear();
        while (hiddenNumbers.size() != NUMBER_OF_DIGIT) {
            int randomNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            insertNumber(randomNumber);
        }
    }

    public GuessResult guessNumber(ArrayList<Integer> guessNumber) {
        GuessResult guessResult = new GuessResult();
        for (int idx = 0; idx < NUMBER_OF_DIGIT; idx++) {
            countStrike(idx, guessNumber.get(idx), guessResult);
            countBall(idx, guessNumber.get(idx), guessResult);
        }
        return guessResult;
    }

    private void insertNumber(int randomNumber) {
        if (!hiddenNumbers.contains(randomNumber)) {
            hiddenNumbers.add(randomNumber);
        }
    }

    private void countBall(int targetIndex, int targetNumber, GuessResult guessResult) {
        for (int idx = 0; idx < NUMBER_OF_DIGIT; idx++) {
            int ball = hiddenNumbers.get(idx) == targetNumber && idx != targetIndex ? 1 : 0;
            guessResult.setBall(guessResult.getBall() + ball);
        }
    }

    private void countStrike(int targetIndex, int targetNumber, GuessResult guessResult) {
        int strike = hiddenNumbers.get(targetIndex) == targetNumber ? 1 : 0;
        guessResult.setStrike(guessResult.getStrike() + strike);
    }

}
