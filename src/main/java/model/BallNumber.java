package model;

import java.util.Objects;

public class BallNumber {
    private final int number;

    private BallNumber(final int number) {
        validate(number);
        this.number = number;
    }

    public void validate(final int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("잘못된 입력입니다");
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

    public static BallNumber of (int number) {
        return new BallNumber(number);
    }
}
