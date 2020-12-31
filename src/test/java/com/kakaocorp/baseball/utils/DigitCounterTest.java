package com.kakaocorp.baseball.utils;

import com.kakaocorp.baseball.utils.DigitCounter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DigitCounterTest {
    private DigitCounter counter;

    @Test
    void zeroShouldCountAsZero() {
        counter = new DigitCounter(0);

        assertThat(counter.getDigitCnt()).isEqualTo(0);
    }

    @Test
    void fiveDigitNumShouldCountAsFive() {
        counter = new DigitCounter(12345);

        assertThat(counter.getDigitCnt()).isEqualTo(5);
    }
}
