package com.sang5c.baseball.domain;

public class BaseballCount {

    private static final int ZERO_COUNT = 0;
    private static final int THREE_STRIKE = 3;

    private final int strikeCount;
    private final int ballCount;

    public BaseballCount() {
        this.strikeCount = ZERO_COUNT;
        this.ballCount = ZERO_COUNT;
    }

    public BaseballCount(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public BaseballCount increaseStrikeCount() {
        return new BaseballCount(strikeCount + 1, ballCount);
    }

    public BaseballCount increaseBallCount() {
        return new BaseballCount(strikeCount, ballCount + 1);
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isThreeStrike() {
        return strikeCount == THREE_STRIKE;
    }

    public boolean isNothing() {
        return ballCount == ZERO_COUNT && strikeCount == ZERO_COUNT;
    }

    @Override
    public String toString() {
        return "Count{" +
                "strikeCount=" + strikeCount +
                ", ballCount=" + ballCount +
                '}';
    }

}
