package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private Map<Score, Integer> result = new HashMap<>();

    public void put(Score score) {
        result.put(score, result.getOrDefault(score, 0) + 1);
    }

    public int getStrikeCount() {
        return result.getOrDefault(Score.STRIKE, 0);
    }

    public int getBallCount() {
        return result.getOrDefault(Score.BALL, 0);
    }

    public boolean isNothing() {
        return getBallCount() == 0 && getStrikeCount() == 0;
    }

    public boolean isGameEnd() {
        return result.getOrDefault(Score.STRIKE, 0) == 3;
    }
}
