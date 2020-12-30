import Model.GuessResult;

import java.util.ArrayList;
import java.util.Random;

public class Computer {
    static final int NUMBER_OF_DIGIT = 3;
    static final int MAX_NUMBER = 9;
    static final int MIN_NUMBER = 1;

    private ArrayList<Integer> hiddenNumbers;

    public Computer() {
        this.hiddenNumbers = new ArrayList<>();
    }

    public ArrayList<Integer> getHiddenNumbers() {
        return hiddenNumbers;
    }

    //This method is only used for test
    public void setHiddenNumbers(String hiddenNumbers) {
        this.hiddenNumbers.clear();
        for(int i=0;i<NUMBER_OF_DIGIT;i++){
            this.hiddenNumbers.add(hiddenNumbers.charAt(i) - '0');
        }
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

    public GuessResult guessNumber(String guessNumber) {
        GuessResult guessResult = new GuessResult();
        for (int idx = 0; idx < NUMBER_OF_DIGIT; idx++) {
            int targetNumber = guessNumber.charAt(idx) - '0';
            countStrike(idx, targetNumber, guessResult);
            countBall(idx, targetNumber, guessResult);
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
