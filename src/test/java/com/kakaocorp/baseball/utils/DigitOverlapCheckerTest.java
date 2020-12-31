package com.kakaocorp.baseball.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DigitOverlapCheckerTest {
    private DigitOverlapChecker checker;
    boolean isValidNum;

    @Test
    void zeroIsValidNum() {
        checker = new DigitOverlapChecker(0);

        isValidNum = checker.isValid();

        assertThat(isValidNum).isTrue();
    }

    @Test
    void twoOverlappingDigitsIsInvalidNum() {
        checker = new DigitOverlapChecker(212);

        isValidNum = checker.isValid();

        assertThat(isValidNum).isFalse();
    }

    @Test
    void maximumValidNumIsOfLengthTen() {
        checker = new DigitOverlapChecker(1234567890);

        isValidNum = checker.isValid();

        assertThat(isValidNum).isTrue();
    }
}
