package com.kakaocorp.baseball.utils;

public class NumWithNoOverlappingDigitGenerator {
    protected static final int REQUIRED_DIGIT_CNT_FOR_GAME = 3;
    private int generatedNum;
    private int randomDigit;

    public int generate() {
        initialize();

        while (!hasEnoughDigitCnt()) {
            pickOneRandomDigitExcludingZero();
            appendRandomDigitToUnitPlaceIfValid();
        }

        return generatedNum;
    }

    private void initialize() {
        clearPreviousGeneratedNum();
    }

    private boolean hasEnoughDigitCnt() {
        DigitCounter counter;
        int digitCnt;

        counter = new DigitCounter(generatedNum);
        digitCnt = counter.getDigitCnt();

        return digitCnt >= REQUIRED_DIGIT_CNT_FOR_GAME;
    }

    private void pickOneRandomDigitExcludingZero() {
        double oneDigitInIntegerPart;

        oneDigitInIntegerPart = Math.random() * 10;
        randomDigit = (int) oneDigitInIntegerPart;

        if (randomDigitIsZero()) {
            pickOneRandomDigitExcludingZero();
        }
    }

    private void appendRandomDigitToUnitPlaceIfValid() {
        DigitOverlapChecker checker;
        int numWithRandomDigitAppendedToUnitPlace;

        numWithRandomDigitAppendedToUnitPlace = generatedNum * 10 + randomDigit;
        checker = new DigitOverlapChecker(numWithRandomDigitAppendedToUnitPlace);

        if (checker.isValid()) {
            pickNewNumAsPartiallyGeneratedNum(numWithRandomDigitAppendedToUnitPlace);
        }
    }

    private void clearPreviousGeneratedNum() {
        generatedNum = 0;
    }

    private boolean randomDigitIsZero() {
        return randomDigit == 0;
    }

    private void pickNewNumAsPartiallyGeneratedNum(int newNum) {
        generatedNum = newNum;
    }
}
