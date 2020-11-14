package baseball.domain;

import java.util.Collections;
import java.util.List;

public class MatchResult {
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
}
