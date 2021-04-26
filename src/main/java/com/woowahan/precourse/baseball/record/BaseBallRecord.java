package com.woowahan.precourse.baseball.record;

import com.woowahan.precourse.baseball.rule.BaseBallRule;

public class BaseBallRecord {

    private int strikeCount;
    private int ballCount;
    private int recordPosition;

    public BaseBallRecord() {
        this.strikeCount = 0;
        this.ballCount = 0;
        this.recordPosition = 0;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public void doRecord(String[] gameNumbers, String[] inputNumbers) {

        for (this.recordPosition = 0; this.recordPosition < 3; this.recordPosition++) {
            countRecord(gameNumbers, inputNumbers);
        }
    }

    private void countRecord(String[] gameNumbers, String[] inputNumbers) {
        String inputNumber = inputNumbers[recordPosition];
        String gameNumber = gameNumbers[recordPosition];

        if (BaseBallRule.isStrike(gameNumber, inputNumber)) {
            this.strikeCount++;
        } else if (BaseBallRule.isBall(gameNumbers, inputNumber)) {
            this.ballCount++;
        }
    }
}
