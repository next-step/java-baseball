package com.github.momentjin.model;

public class BaseballNumberMatchResult {

    private final int bundleSize;
    private final int strikeCount;
    private final int ballCount;
    private final String errorMessage;

    public BaseballNumberMatchResult(BaseballNumberDomainException e) {
        this.bundleSize = 0;
        this.strikeCount = 0;
        this.ballCount = 0;
        this.errorMessage = e.getMessage();
    }

    public BaseballNumberMatchResult(int bundleSize, int strikeCount, int ballCount) {
        this.bundleSize = bundleSize;
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.errorMessage = "";
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

    public boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isError() {
        return errorMessage != null && !errorMessage.isEmpty();
    }
}
