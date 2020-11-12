package baseball.domain;

import baseball.exception.IllegalBallNumberException;

public class BallNumber {

    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;

    private int number;

    public BallNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalBallNumberException();
        }
    }
}
