package domain;

import java.util.Objects;
import java.util.Random;

public class BaseballNumber {
    private final int number;

    public BaseballNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException("BaseballNumber는 한 자리의 숫자여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
