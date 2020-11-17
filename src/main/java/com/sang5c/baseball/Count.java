package com.sang5c.baseball;

public class Count {

    private final int strikeCount;
    private final int ballCount;

    public Count(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
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
