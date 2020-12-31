package com.kakaocorp.baseball.utils;

import java.util.Arrays;

public class DigitOverlapChecker {
    protected static final int ARABIC_DIGIT_CNT = 10;
    private final int targetNum;
    private int[] digitUsedCnts;
    private boolean isValidNum;
    private int numForUse;

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
        numForUse = targetNum;
    }

    private void assumeValidNum() {
        isValidNum = true;
    }

    private boolean hasRemainingDigit() {
        DigitCounter counter = new DigitCounter(numForUse);
        return counter.getDigitCnt() > 0;
    }

    private void increaseCounterForRightmostDigit() {
        int rightmostDigit = numForUse % 10;
        digitUsedCnts[rightmostDigit]++;
    }

    private void trimRightmostDigit() {
        numForUse /= 10;
    }

    private void checkIsUsedOnce(int digitUsedCnt) {
        if (digitUsedCnt >= 2) {
            isValidNum = false;
        }
    }
}
