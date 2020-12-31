package com.kakaocorp.baseball.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NumWithNoOverlappingDigitGeneratorTest {
    private NumWithNoOverlappingDigitGenerator generator;
    private int generatedNum;

    @Test
    void digitsDoNotOverlap() {
        DigitOverlapChecker checker;

        generator = new NumWithNoOverlappingDigitGenerator();
        generatedNum = generator.generate();
        checker = new DigitOverlapChecker(generatedNum);

        assertThat(checker.isValid()).isTrue();
    }

    @Test
    void numberHasThreeDigits() {
        DigitCounter counter;

        generator = new NumWithNoOverlappingDigitGenerator();
        generatedNum = generator.generate();
        counter = new DigitCounter(generatedNum);

        assertThat(counter.getDigitCnt()).isEqualTo(
                NumWithNoOverlappingDigitGenerator.REQUIRED_DIGIT_CNT_FOR_GAME);
    }
}
