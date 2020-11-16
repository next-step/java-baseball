package domain;

import java.util.HashMap;
import java.util.Map;

public class ResultGame {
    private static final int ALL_STRIKE_COUNT = 3;

    private final Map<Score, Integer> scores;

    public ResultGame() {
        scores = new HashMap<>();
    }

    public void add(final Score score) {
        scores.put(score, count(score) + 1);
    }

    public boolean isAllStrike() {
        return count(Score.STRIKE) == ALL_STRIKE_COUNT;
    }

    public boolean isNothing() {
        return count(Score.STRIKE) == 0 && count(Score.BALL) == 0;
    }

    public int count(final Score score) {
        return scores.getOrDefault(score, 0);
    }
}
