package com.jaeeyeonling.baseball.referee;

import com.jaeeyeonling.baseball.ball.Balls;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public final class JudgeReport {

    private static final int DEFAULT_COUNT = 0;
    private static final int INCREMENT_COUNT = 1;

    private final Map<Judge, Integer> value;

    private JudgeReport(final Map<Judge, Integer> value) {
        this.value = new EnumMap<>(value);
    }

    public static JudgeReport empty() {
        return of(new EnumMap<>(Judge.class));
    }

    public static JudgeReport of(final Map<Judge, Integer> value) {
        return new JudgeReport(value);
    }

    public void increment(final Judge... judges) {
        for (final var judge : judges) {
            increment(judge);
        }
    }

    public void increment(final Judge judge) {
        set(judge, getCount(judge) + INCREMENT_COUNT);
    }

    public void set(final Judge judge, int count) {
        value.put(judge, count);
    }

    public int getCount(final Judge judge) {
        return value.getOrDefault(judge, DEFAULT_COUNT);
    }

    public boolean isComplete() {
        return getCount(Judge.STRIKE) == Balls.SIZE;
    }

    public boolean isNothing() {
        return getCount(Judge.MISS) == Balls.SIZE;
    }

    public boolean hasStrike() {
        return getCount(Judge.STRIKE) > DEFAULT_COUNT;
    }

    public boolean hasBall() {
        return getCount(Judge.BALL) > DEFAULT_COUNT;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final var that = (JudgeReport) o;
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
