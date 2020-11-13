package com.sang5c.baseball;

public class CountDto {

    private int ballCount;
    private int strikeCount;

    public void increaseBallCount() {
        ballCount++;
    }

    public void increaseStrikeCount() {
        strikeCount++;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isThreeStrike() {
        return strikeCount == 3;
    }

}
