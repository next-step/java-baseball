package com.kakaocorp.baseball.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NumWithNoOverlappingDigitGeneratorTest {
    private NumWithNoOverlappingDigitGenerator generator;
    private int generatedNum;

    @Test
    void digitsDoNotOverlap() {
        DigitOverlapChecker checker;
        boolean isValidNum;

        generator = new NumWithNoOverlappingDigitGenerator();
        generatedNum = generator.generate();

        checker = new DigitOverlapChecker(generatedNum);
        isValidNum = checker.validate();

        assertThat(isValidNum).isTrue();
    }

    @Test
    void numberHasThreeDigits() {
        DigitCounter counter;
        int digitCnt;

        generator = new NumWithNoOverlappingDigitGenerator();
        generatedNum = generator.generate();

        counter = new DigitCounter(generatedNum);
        digitCnt = counter.getDigitCnt();

        assertThat(digitCnt).isEqualTo(
                NumWithNoOverlappingDigitGenerator.REQUIRED_DIGIT_CNT_FOR_GAME);
    }
}
