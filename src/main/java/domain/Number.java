package domain;

import java.util.Objects;

public class Number {
    private static final String NUMBER_REGEX;

    static {
        NUMBER_REGEX = "[1-9]";
    }

    private final Integer number;

    private Number(final Integer number) {
        this.number = number;
    }

    public static Number of(final String digit) {
        validate(digit);
        return new Number(Integer.parseInt(digit));
    }

    public static Number of(final Integer digit) {
        validate(digit.toString());
        return new Number(digit);
    }

    private static void validate(final String digit) {
        if (!digit.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return Objects.equals(number, number1.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
