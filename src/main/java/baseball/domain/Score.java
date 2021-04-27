package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Score {
    private final List<Pitching> pitchings;

    public Score(List<Pitching> pitchings) {
        this.pitchings = new ArrayList<>(pitchings);
    }

    public int countOfStrike() {
        return countOf(Pitching.STRIKE);
    }

    public int countOfBall() {
        return countOf(Pitching.BALL);
    }

    public int countOfMissing() {
        return countOf(Pitching.MISSING);
    }

    public boolean isNotAllStrike() {
        return !isAllStrike();
    }

    public boolean isAllStrike() {
        return countOfStrike() == pitchings.size();
    }

    private int countOf(Pitching pitching) {
        return Collections.frequency(pitchings, pitching);
    }
}
