package com.sang5c.baseball;

public class Count {

    private final int strikeCount;
    private final int ballCount;

    public Count(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public Count increaseStrikeCount() {
        return new Count(strikeCount + 1, ballCount);
    }

    public Count increaseBallCount() {
        return new Count(strikeCount, ballCount + 1);
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isThreeStrike() {
        return strikeCount == 3;
    }

    public boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }

}
