package model.domain;

import exception.BaseballException;
import exception.ExceptionStatus;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Ball {
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;

    private int number;

    private Ball(int number) {
        this.number = number;
    }

    public static Ball of(int number) {
        validation(number);
        return new Ball(number);
    }

    private static void validation(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new BaseballException(ExceptionStatus.INVALID_BALL_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
