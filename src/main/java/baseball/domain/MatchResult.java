package baseball.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MatchResult {
    public static final int FINISH_STRIKE_COUNT = 3;
    private final List<State> states;

    public MatchResult(final List<State> states) {
        this.states = Collections.unmodifiableList(states);
    }

    public int strikeCount() {
        return Collections.frequency(states, State.STRIKE);
    }

    public int ballCount() {
        return Collections.frequency(states, State.BALL);
    }

    public boolean isFinish() {
        return Collections.frequency(states, State.STRIKE) == FINISH_STRIKE_COUNT;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchResult)) return false;
        final MatchResult that = (MatchResult) o;
        return Objects.equals(states, that.states);
    }

    @Override
    public int hashCode() {
        return Objects.hash(states);
    }
}
