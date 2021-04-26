package dev.heowc.ball;

import java.util.Objects;

public final class Ball {

    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 9;

    private final int value;

    private Ball(final int value) {
        this.value = value;
    }

    public static Ball valueOf(final String value) {
        return valueOf(Integer.parseInt(value));
    }

    public static Ball valueOf(final int value) {
        return new Ball(validate(value));
    }

    private static int validate(final int value) {
        if (MIN_VALUE > value || value > MAX_VALUE) {
            throw new BallOutOfBoundsException(value);
        }

        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Ball other = (Ball) o;
        return value == other.value;
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