package domain;

import java.util.Objects;

public class GameDigit {
    public static final int MIN_DIGIT = 0;
    public static final int MAX_DIGIT = 9;

    private final int digit;

    public GameDigit(int digit) {
        validate(digit);
        this.digit = digit;
    }

    private void validate(int number) {
        if (number < MIN_DIGIT || number > MAX_DIGIT) {
            throw new IllegalArgumentException("GameDigit은 한 자리의 숫자여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameDigit that = (GameDigit) o;
        return digit == that.digit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(digit);
    }

    @Override
    public String toString() {
        return String.valueOf(digit);
    }
}
