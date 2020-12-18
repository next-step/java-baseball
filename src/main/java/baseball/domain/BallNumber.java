package baseball.domain;

import java.util.Objects;

public class BallNumber {
    private static final int MIN_VALID_NUMBER = 1;
    private static final int MAX_VALID_NUMBER = 9;

    private final int number;

    public BallNumber(int number) {
        requireInRangeOneToNine(number);

        this.number = number;
    }

    private static void requireInRangeOneToNine(int number) {
        if (number < MIN_VALID_NUMBER || number > MAX_VALID_NUMBER) {
            throw new IllegalArgumentException("1~9 사이의 숫자만 허용됩니다.");
        }
    }

    public int getNumber() {
        return number;
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
