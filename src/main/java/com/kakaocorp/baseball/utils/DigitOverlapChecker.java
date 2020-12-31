package com.kakaocorp.baseball.utils;

import java.util.Arrays;

public class DigitOverlapChecker {
    protected static final int ARABIC_DIGIT_CNT = 10;
    private final int targetNum;
    private int[] digitUsedCnts;
    private boolean isValidNum;
    private int temp;

    public DigitOverlapChecker(int targetNum) {
        this.targetNum = targetNum;
    }

    public boolean isValid() {
        initialize();

        countDigitUsage();
        checkAllDigitsAreUsedOnce();

        return isValidNum;
    }

    private void initialize() {
        markAllDigitsAsUnused();
        backupOriginalNum();
        assumeValidNum();
    }

    private void countDigitUsage() {
        while (hasRemainingDigit()) {
            increaseCounterForRightmostDigit();
            trimRightmostDigit();
        }
    }

    private void checkAllDigitsAreUsedOnce() {
        for (int i = 0; i < ARABIC_DIGIT_CNT; i++) {
            checkIsUsedOnce(digitUsedCnts[i]);
        }
    }

    private void markAllDigitsAsUnused() {
        digitUsedCnts = new int[ARABIC_DIGIT_CNT];
        Arrays.fill(digitUsedCnts, 0);
    }

    private void backupOriginalNum() {
        temp = targetNum;
    }

    private void assumeValidNum() {
        isValidNum = true;
    }

    private boolean hasRemainingDigit() {
        DigitCounter counter;
        int digitCnt;

        counter = new DigitCounter(temp);
        digitCnt = counter.getDigitCnt();

        return digitCnt > 0;
    }

    private void increaseCounterForRightmostDigit() {
        int rightmostDigit = temp % 10;
        digitUsedCnts[rightmostDigit]++;
    }

    private void trimRightmostDigit() {
        temp /= 10;
    }

    private void checkIsUsedOnce(int digitUsedCnt) {
        if (digitUsedCnt >= 2) {
            isValidNum = false;
        }
    }
}
