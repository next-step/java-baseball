package com.jaeeyeonling.baseball.ball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class Balls {

    public static final int SIZE = 3;

    private static final String DELIMITER = "";

    private final List<Ball> value;

    private Balls(final List<Ball> value) {
        this.value = new ArrayList<>(value);
    }

    public static Balls of(final String value) {
        final var splitValue = validate(value).split(DELIMITER);
        return of(splitValue);
    }

    public static Balls of(final String... value) {
        final var values = new int[SIZE];
        for (var i = 0; i < value.length; i++) {
            values[i] = Integer.parseInt(value[i]);
        }

        return of(values);
    }

    public static Balls of(final int... value) {
        final var values = new ArrayList<Ball>(SIZE);
        for (final var intValue : value) {
            values.add(Ball.valueOf(intValue));
        }

        return of(values);
    }

    public static Balls of(final Set<Ball> value) {
        return of(new ArrayList<>(value));
    }

    public static Balls of(final List<Ball> value) {
        return new Balls(validate(value));
    }

    private static String validate(final String value) {
        if (value.length() != SIZE) {
            throw new BallsSizeException(value);
        }

        return value;
    }

    private static List<Ball> validate(final List<Ball> value) {
        final var removeDuplicatedValue = new HashSet<>(value);
        if (removeDuplicatedValue.size() != SIZE) {
            throw new BallsSizeException(value);
        }

        return value;
    }

    public Ball get(final int index) {
        return value.get(index);
    }

    public boolean contains(final Ball ball) {
        return value.contains(ball);
    }

    public boolean match(final Balls other,
                         final int index) {
        final var myBall = get(index);
        final var otherBall = other.get(index);

        return myBall.equals(otherBall);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final var that = (Balls) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
