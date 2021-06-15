package domain;

import domain.exception.BallNumberNotValidRangeException;

public class BallNumber {
    public static final int MIN_BALL_NUMBER = 1;
    public static final int MAX_BALL_NUMBER = 9;

    private int number;

    private BallNumber(int number) {
        numberRangeCheck(number);
        this.number = number;
    }

    public static BallNumber valueOf(int number) {
        return new BallNumber(number);
    }

    private void numberRangeCheck(int number) {
        if (number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER) {
            throw new BallNumberNotValidRangeException();
        }
    }

    public int number() {
        return this.number;
    }
}
