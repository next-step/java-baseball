package com.baseball.precourse.util;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DigitRandomTest {

    @DisplayName("랜덤한 수 문자열 생성")
    @Test
    void generateRandomLengthTest(){
        // given
        DigitRandom random = new DigitRandom();

        // when
        String result = random.generateRandom(2);

        // then
        assertThat(result.length()).isEqualTo(2);
        assertThat(result).containsOnlyDigits();
    }

    @DisplayName("랜덤한 수 문자열 생성 - 최대 길이 초")
    @Test
    void generateRandomLengthOverMaximumTest(){
        // given
        DigitRandom random = new DigitRandom();

        // then
        assertThatThrownBy(()->{
            // when
            random.generateRandom(DigitRandom.MAX_RANDOM_LENGTH+1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
