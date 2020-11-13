package com.yebgi83.baseball.model;

public class PatternResult {
    private final int strikeCount;

    private final int ballCount;

    public PatternResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }
}
