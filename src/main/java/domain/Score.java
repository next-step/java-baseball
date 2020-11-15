package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Score {
    STRIKE("%d 스트라이크", 2),
    BALL("%d 볼", 1),
    NOTHING("낫싱", 0);

    private final String score;
    private final int matchpoint;

    Score(String score, int matchpoint) {
        this.score = score;
        this.matchpoint = matchpoint;
    }

    public static Score findScore(int matchPoint) {
        List<Score> result = new ArrayList<>();

        for (Score score : values()) {
            result.add(score.find(matchPoint));
        }
        Collections.sort(result);
        return result.get(0);
    }

    private Score find(int matchPoint) {
        if (this.matchpoint == matchPoint) {
            return this;
        }
        return NOTHING;
    }

    public String getScoreMessage() {
        return score;
    }
}
