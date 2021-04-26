package dev.heowc.ball;

import java.util.*;

import static java.util.Objects.requireNonNull;

public final class Balls {

    public static final int SIZE = 3;

    private final List<Ball> value;

    private Balls(List<Ball> value) {
        this.value = Collections.unmodifiableList(value);
    }

    public static Balls of(List<Ball> value) {
        return new Balls(validate(value));
    }

    private static List<Ball> validate(List<Ball> value) {
        final Set<Ball> uniqueBalls = new HashSet<>(value);
        if (uniqueBalls.size() != SIZE) {
            throw new InvalidBallSizeException(value);
        }

        return value;
    }

    public Ball get(int index) {
        return value.get(index);
    }

    public int indexOf(Ball ball) {
        return value.indexOf(ball);
    }

    public boolean match(Balls other, int index) {
        final Ball myBall = get(index);
        final Ball otherBall = other.get(index);

        return myBall.equals(otherBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Balls other = (Balls) o;
        return Objects.equals(value, other.value);
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
