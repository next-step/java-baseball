package baseball.domain;

import baseball.exceptions.InvalidBallNumberException;

import java.util.Objects;

public class BallNumber {
    private int number;

    public BallNumber(int number) {
        validation(number);
        this.number = number;
    }

    private void validation(int number) {
        if (number < 1 || number > 9) {
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
