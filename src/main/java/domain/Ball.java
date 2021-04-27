package domain;

import java.util.Objects;

public class Ball {
    private static final String RANGE_ERROR = "숫자범위는 1 ~ 9 입니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int numberBall;

    public Ball(int number) {
        validNumberRange(number);
        this.numberBall = number;
    }

    private void validNumberRange(int number) {
        if (number < MIN_NUMBER
                || MAX_NUMBER < number) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    public int toInt() {
        return numberBall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball that = (Ball) o;
        return numberBall == that.numberBall;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberBall);
    }
}
