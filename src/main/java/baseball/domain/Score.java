package baseball.domain;

import java.util.Collections;
import java.util.List;

public class Score {
    private final List<GameRule> gameRules;

    public Score(List<GameRule> gameRules) {
        this.gameRules = gameRules;
    }

    public int countOfStrike() {
        return countOf(GameRule.STRIKE);
    }

    public int countOfBall() {
        return countOf(GameRule.BALL);
    }

    public int countOfMissing() {
        return countOf(GameRule.MISSING);
    }

    public boolean isNotAllStrike() {
        return !isAllStrike();
    }

    public boolean isAllStrike() {
        return countOfStrike() == gameRules.size();
    }

    private int countOf(GameRule gameRule) {
        return Collections.frequency(gameRules, gameRule);
    }
}
