package com.jaeeyeonling.baseball.ball;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

public final class Ball {

    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 9;

    private static final Map<Integer, Ball> CACHE = new WeakHashMap<>(MAX_VALUE);

    private final int value;

    private Ball(final int value) {
        this.value = value;
    }

    public static Ball valueOf(final String value) {
        return valueOf(Integer.parseInt(value));
    }

    public static Ball valueOf(final int value) {
        return CACHE.computeIfAbsent(validate(value), Ball::new);
    }

    private static int validate(final int value) {
        if (MIN_VALUE > value || value > MAX_VALUE) {
            throw new BallOutOfRangeException(value);
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
        final var that = (Ball) o;
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
