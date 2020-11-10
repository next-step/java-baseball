package com.game.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberUtilTest {

    @Test
    void isValidRandomNumber_successTest() {
        // given
        int min = 1;
        int max = 2;

        // when
        int randomNumber = NumberUtil.randomNumber(min, max);

        // then
        assertThat(randomNumber).isGreaterThanOrEqualTo(min).isLessThanOrEqualTo(max);
    }
}
