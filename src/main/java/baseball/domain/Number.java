package baseball.domain;

import baseball.exception.NumberOutOfRangeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Number {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    private static final List<Number> CACHE = new ArrayList<>(MAX_VALUE);

    static {
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            CACHE.add(new Number(i));
        }
    }

    private final int value;

    private Number(int value) {
        this.value = value;
    }

    public static Number valueOf(final String value) {
        return valueOf(Integer.parseInt(value));
    }

    public static Number valueOf(final int value) {
        validate(value);
        Number number = CACHE.get(value - 1);
        if (Objects.isNull(number)) {
            number = new Number(1);
        }
        return number;
    }

    private static int validate(final int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new NumberOutOfRangeException(value);
        }
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final var that = (Number) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
