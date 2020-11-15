package domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private static final int DEFAULT_VALUE = 0;
    private static final int INCREASE = 1;
    private static final int END = 3;

    private Map<Score, Integer> result = new HashMap<>();

    public void put(Score score) {
        result.put(score, result.getOrDefault(score, DEFAULT_VALUE) + INCREASE);
    }

    public int getStrikeCount() {
        return result.getOrDefault(Score.STRIKE, DEFAULT_VALUE);
    }

    public int getBallCount() {
        return result.getOrDefault(Score.BALL, DEFAULT_VALUE);
    }

    public boolean isNothing() {
        return getBallCount() == DEFAULT_VALUE && getStrikeCount() == DEFAULT_VALUE;
    }

    public boolean isGameEnd() {
        return result.getOrDefault(Score.STRIKE, DEFAULT_VALUE) == END;
    }
}
