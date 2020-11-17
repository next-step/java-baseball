package com.sang5c.baseball.domain;

public class BaseballCount {
    
    private static final int ZERO_COUNT = 0;
    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 3;
    private static final int THREE_STRIKE = 3;

    private final int ballCount;
    private final int strikeCount;

    private BaseballCount(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public static BaseballCount of(int ballCount, int strikeCount) {
        if (invalidCountSum(ballCount, strikeCount)) {
            throw new IllegalArgumentException("count error");
        }
        return new BaseballCount(ballCount, strikeCount);
    }

    private static boolean invalidCountSum(int ballCount, int strikeCount) {
        return invalidRange(ballCount + strikeCount) || invalidRange(ballCount) || invalidRange(strikeCount);
    }

    private static boolean invalidRange(int count) {
        return count < MIN_COUNT || count > MAX_COUNT;
    }

    public boolean isNothing() {
        return ballCount == ZERO_COUNT && strikeCount == ZERO_COUNT;
    }

    public BaseballCount increaseBallCount() {
        return new BaseballCount(ballCount + 1, strikeCount);
    }

    public int getBallCount() {
        return ballCount;
    }

    public BaseballCount increaseStrikeCount() {
        return new BaseballCount(ballCount, strikeCount + 1);
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isThreeStrike() {
        return strikeCount == THREE_STRIKE;
    }

    @Override
    public String toString() {
        return "BaseballCount{" +
                "ballCount=" + ballCount +
                ", strikeCount=" + strikeCount +
                '}';
    }

}
