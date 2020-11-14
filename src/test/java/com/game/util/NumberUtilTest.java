package com.game.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberUtilTest {

    @ParameterizedTest
    @CsvSource(value = {"1~9", "2~5", "8~9"}, delimiter = '~')
    void isValidRandomNumber_successTest(int min, int max) {
        // when
        int randomNumber = NumberUtil.randomNumber(min, max);

        // then
        assertThat(randomNumber).isGreaterThanOrEqualTo(min).isLessThanOrEqualTo(max);
    }
}
