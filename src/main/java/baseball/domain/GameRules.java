package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameRules {
    private final Map<GameRule, Integer> countOfRule = new HashMap<>();

    public GameRules(List<GameRule> gameRules) {
        GameRule[] values = GameRule.values();
        for(GameRule rule : values) {
            countOfRule.put(rule, 0);
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

        countOfRule.put(gameRule, count + 1);
    }

    public boolean isNotEndGame() {
        return !isEndGame();
    }

    public boolean isEndGame() {
        return countOfBall() == 0 && countOfMissing() == 0;
    }
}
