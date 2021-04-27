package baseball.domain;

import baseball.exceptions.InvalidBallNumberException;

import java.util.Objects;

public class BallNumber {
    public static final int VALID_MIN_NUMBER = 1;
    public static final int VALID_MAX_NUMBER = 9;
    private int number;

    public BallNumber(int number) {
        validation(number);
        this.number = number;
    }

    private void validation(int number) {
        if (number < VALID_MIN_NUMBER || number > VALID_MAX_NUMBER) {
            throw new InvalidBallNumberException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BallNumber)) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
