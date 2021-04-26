package baseball.domain;

import java.util.Objects;

public class BallNumber {
    public static final int MAXIMUM_BALL_NUMBER = 9;
    public static final int MINIMUM_BALL_NUMBER = 1;
    public static final String BALL_VALID_RANGE = "공은 1과 9사이의 숫자만 가능합니다.";
    private final int number;

    public BallNumber(int number) {
        this.number = validate(number);
    }

    private int validate(int number) {
        if (number < MINIMUM_BALL_NUMBER || number > MAXIMUM_BALL_NUMBER) {
            throw new IllegalArgumentException(BALL_VALID_RANGE);
        }
        return number;
    }

    public int getNumber() {
        return number;
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
