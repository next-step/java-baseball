package baseball.domain;

public class BaseballGame {

    private static final int NOTHING_COUNT = 0;

    private final BaseballNumbers baseballNumbers;

    public BaseballGame(BaseballNumbers baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public int getStrikeCount(BaseballNumbers attack) {
        return baseballNumbers.equalsCount(attack);
    }

    public int getBallCount(BaseballNumbers attack) {
        return baseballNumbers.containsCount(attack) - baseballNumbers.equalsCount(attack);
    }

    public boolean isFinish(BaseballNumbers attack) {
        return baseballNumbers.size() == getStrikeCount(attack);
    }

    public boolean isNothing(BaseballNumbers attack) {
        return baseballNumbers.containsCount(attack) == NOTHING_COUNT;
    }
}
