package com.kakaocorp.baseball.utils;

public class DigitCounter {
    private final int targetNum;
    private int digitCnt;
    private int temp;

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
        return temp > 0;
    }

    private void increaseCounter() {
        digitCnt++;
    }

    private void trimOneDigit() {
        temp /= 10;
    }

    private void setCounterToZero() {
        digitCnt = 0;
    }

    private void backupOriginalNum() {
        temp = targetNum;
    }
}
