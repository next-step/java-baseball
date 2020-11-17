package me.kingcjy.baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author KingCjy
 */
public class BallCount {

    private Map<Score, Integer> scores;

    public BallCount(List<Score> scores) {
        this.scores = new HashMap<>();

        for (Score score : scores) {
            int count = this.scores.getOrDefault(score, 0) + 1;
            this.scores.put(score, count);
        }
    }

    public boolean isFinish() {
        return countStrike() == 3;
    }

    public int countStrike() {
        return scores.getOrDefault(Score.STRIKE, 0);
    }

    public int countBall() {
        return scores.getOrDefault(Score.BALL, 0);
    }
}
