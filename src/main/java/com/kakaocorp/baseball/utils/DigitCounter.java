package com.kakaocorp.baseball.utils;

public class DigitCounter {
    private final int targetNum;
    private int digitCnt;
    private int numForUse;

    public DigitCounter(int targetNum) {
        this.targetNum = targetNum;
    }

    public int getDigitCnt() {
        initialize();

        while (hasRemainingDigit()) {
            increaseCounter();
            trimOneDigit();
        }

        return digitCnt;
    }

    private void initialize() {
        setCounterToZero();
        backupOriginalNum();
    }

    private boolean hasRemainingDigit() {
        return numForUse > 0;
    }

    private void increaseCounter() {
        digitCnt++;
    }

    private void trimOneDigit() {
        numForUse /= 10;
    }

    private void setCounterToZero() {
        digitCnt = 0;
    }

    private void backupOriginalNum() {
        numForUse = targetNum;
    }
}
