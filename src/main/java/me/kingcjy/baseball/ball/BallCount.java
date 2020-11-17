package me.kingcjy.baseball.ball;

import me.kingcjy.baseball.Baseball;

import java.util.*;

/**
 * @author KingCjy
 */
public class BallCount {

    private Map<Score, Integer> scores = new HashMap<>();

    public BallCount() {
        this(Collections.EMPTY_LIST);
    }

    public BallCount(List<Score> scores) {
        for (Score score : scores) {
            int count = this.scores.getOrDefault(score, 0) + 1;
            this.scores.put(score, count);
        }
    }

    public boolean isFinish() {
        return countStrike() == Baseball.DIGIT;
    }

    public int countStrike() {
        return countByScore(Score.STRIKE);
    }

    public int countBall() {
        return countByScore(Score.BALL);
    }

    public String getMessage() {
        String message = (getMessageByScore(Score.STRIKE) + getMessageByScore(Score.BALL)).trim();

        if ("".equals(message)) {
            return Score.NOTHING.getDisplayName();
        }

        return message;
    }

    private String getMessageByScore(Score score) {
        if (scores.get(score) == null) {
            return "";
        }

        return " " + scores.get(score) + " " + score.getDisplayName();
    }

    private int countByScore(Score score) {
        return scores.getOrDefault(score, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallCount ballCount = (BallCount) o;
        return Objects.equals(scores, ballCount.scores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scores);
    }
}
