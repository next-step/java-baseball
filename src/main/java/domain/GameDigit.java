package domain;

import java.util.Objects;

public class GameDigit {
    private final int digit;

    public GameDigit(int digit) {
        validate(digit);
        this.digit = digit;
    }

    private void validate(int number) {
        if (number < 0 || number > 9) {
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
}
