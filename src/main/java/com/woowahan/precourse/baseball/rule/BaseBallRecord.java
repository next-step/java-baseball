package com.woowahan.precourse.baseball.rule;

public class BaseBallRecord {

    private int strikeCount;
    private int ballCount;

    public BaseBallRecord() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void doRecord(String[] gameNumbers, String[] inputNumbers) {

        for (int i = 0; i < 3; i++) {
            countRecord(gameNumbers[i], inputNumbers[i]);
        }
    }

    private void countRecord(String gameNumber, String inputNumber) {
        if (BaseBallRule.isStrike(gameNumber, inputNumber)) {
            this.strikeCount++;
        } else if (BaseBallRule.isBall(gameNumber, inputNumber)) {
            this.ballCount++;
        }
    }
}
