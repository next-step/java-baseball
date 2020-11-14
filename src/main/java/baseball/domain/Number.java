package baseball.domain;

import java.util.Objects;

public class Number {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    private final int number;

    public Number(final int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("숫자는 %d와 %d 사이의 숫자여야 합니다.", MIN_NUMBER, MAX_NUMBER));
        }
        this.number = number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        final Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
