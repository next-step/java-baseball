package com.sang5c.baseball.domain;

public class BaseballCount {
    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 3;

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

}
