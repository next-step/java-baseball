package com.github.momentjin.model;

public class BaseballNumberMatchResult {

    private final int bundleSize;
    private final int strikeCount;
    private final int ballCount;

    public BaseballNumberMatchResult(int bundleSize, int strikeCount, int ballCount) {
        this.bundleSize = bundleSize;
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
    
    public boolean isMatch() {
        return ballCount == 0 && strikeCount == bundleSize;
    }
}
