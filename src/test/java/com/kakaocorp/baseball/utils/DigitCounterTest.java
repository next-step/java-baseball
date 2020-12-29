package com.kakaocorp.baseball.utils;

import com.kakaocorp.baseball.utils.DigitCounter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DigitCounterTest {
    private DigitCounter counter;
    private int digitCnt;
    
    @Test
    void zeroShouldCountAsZero() {
        counter = new DigitCounter(0);
        digitCnt = counter.getDigitCnt();

        assertThat(digitCnt).isEqualTo(0);
    }

    @Test
    void fiveDigitNumShouldCountAsFive() {
        counter = new DigitCounter(12345);
        digitCnt = counter.getDigitCnt();

        assertThat(digitCnt).isEqualTo(5);
    }
}
