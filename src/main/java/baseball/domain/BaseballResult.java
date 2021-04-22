package baseball.domain;

import java.util.Map;

public class BaseballResult {
    private final Map<BaseballEnum, Integer> baseballCounts;

    public BaseballResult(final Map<BaseballEnum, Integer> baseballCounts) {
        this.baseballCounts = baseballCounts;
    }

    public boolean isNothing() {
        return baseballCounts.get(BaseballEnum.OUT) == 3;
    }

    public String getResult() {
        return baseballCounts.get(BaseballEnum.STRIKE) +
                " " +
                BaseballEnum.STRIKE.getMessage() +
                " " +
                baseballCounts.get(BaseballEnum.BALL) +
                " " +
                BaseballEnum.BALL.getMessage();
    }
}
