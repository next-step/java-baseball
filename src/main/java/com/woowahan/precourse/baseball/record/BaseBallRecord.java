package com.woowahan.precourse.baseball.record;

public class BaseBallRecord {

    private int strikeCount;
    private int ballCount;

    public BaseBallRecord() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public void doStrike() {
        this.strikeCount++;
    }

    public void doBall() {
        this.ballCount++;
    }
}
