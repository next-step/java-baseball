package dev.heowc.referee;

import dev.heowc.ball.Balls;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public final class JudgmentReport {

    private static final String DELIMITER = " ";
    private static final int DEFAULT_COUNT = 0;

    private final Map<Judgment, Integer> value;

    private JudgmentReport(final Map<Judgment, Integer> value) {
        this.value = new EnumMap<>(value);
    }

    public static JudgmentReport empty() {
        return of(new EnumMap<>(Judgment.class));
    }

    public static JudgmentReport of(final Map<Judgment, Integer> value) {
        return new JudgmentReport(value);
    }

    public void increment(final Judgment judgment) {
        value.merge(judgment, 1, Integer::sum);
    }

    public int count(final Judgment judgment) {
        return value.getOrDefault(judgment, DEFAULT_COUNT);
    }

    public boolean isCompleted() {
        return value.getOrDefault(Judgment.STRIKE, DEFAULT_COUNT) == Balls.SIZE;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final JudgmentReport other = (JudgmentReport) o;
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

    public String prettyHint() {
        final StringBuilder builder = new StringBuilder();
        for (Map.Entry<Judgment, Integer> entry : value.entrySet()) {
            final Judgment judgment = entry.getKey();
            final int count = entry.getValue();
            builder.append(judgment.hint(count))
                   .append(DELIMITER);
        }
        return builder.toString().trim();
    }
}
