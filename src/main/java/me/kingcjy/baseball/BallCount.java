package me.kingcjy.baseball;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author KingCjy
 */
public class BallCount {

    private Map<Score, Integer> scores;

    public BallCount() {
        this(Collections.EMPTY_LIST);
    }

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

    public void printResult() {
        String message = getMessageByScore(Score.STRIKE) + getMessageByScore(Score.BALL);

        if ("".equals(message.trim())) {
            System.out.println(Score.NOTHING.getDisplayName());
            return;
        }

        System.out.println(message.trim());
    }

    private String getMessageByScore(Score score) {
        if (scores.get(score) == null) {
            return "";
        }

        return " " + scores.get(score) + " " + score.getDisplayName();
    }
}
