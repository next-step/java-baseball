package baseball.domain;

import baseball.exception.IllegalBallNumberException;

import java.util.Objects;

public class BallNumber {

    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;
    private static final String RANGE_ERROR_MESSAGE = "1~9 사이의 정수만 생성 가능";

    private int number;

    public BallNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalBallNumberException(RANGE_ERROR_MESSAGE);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
