package baseball.domain;

public class BaseballGame {

    private static final int NOTHING_COUNT = 0;

    private final BaseballNumbers defence;
    private final BaseballNumbers pitch;

    public BaseballGame(BaseballNumbers defence, BaseballNumbers pitch) {
        this.defence = defence;
        this.pitch = pitch;
    }

    public int getStrikeCount() {
        return defence.equalsCount(this.pitch);
    }

    public int getBallCount() {
        return defence.containsCount(this.pitch) - defence.equalsCount(this.pitch);
    }

    public boolean isFinish() {
        return defence.size() == getStrikeCount();
    }

    public boolean isNothing() {
        return defence.containsCount(this.pitch) == NOTHING_COUNT;
    }
}
