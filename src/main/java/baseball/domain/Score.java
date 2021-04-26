package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {
    private static final int INIT_COUNT = 0;

    private final Map<GameRule, Integer> countOfRule = new HashMap<>();

    public Score(List<GameRule> gameRules) {
        GameRule[] values = GameRule.values();
        for(GameRule rule : values) {
            countOfRule.put(rule, INIT_COUNT);
        }

        for(GameRule rule : gameRules) {
            increase(rule);
        }
    }

    public int countOfStrike() {
        return countOfRule.get(GameRule.STRIKE);
    }

    public int countOfBall() {
        return countOfRule.get(GameRule.BALL);
    }

    public int countOfMissing() {
        return countOfRule.get(GameRule.MISSING);
    }

    private void increase(GameRule gameRule) {
        Integer count = countOfRule.get(gameRule);

        countOfRule.put(gameRule, ++count);
    }

    public boolean isNotEndGame() {
        return !isEndGame();
    }

    public boolean isEndGame() {
        return countOfBall() == INIT_COUNT && countOfMissing() == INIT_COUNT;
    }
}
