package com.baseball.precourse.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class DigitStringTest {

    @DisplayName("유니크 한 숫자 뽑기")
    @ParameterizedTest
    @CsvSource(value = {"123:123", "111:1", "122334:1234"}, delimiter = ':')
    void uniqueStringTest(String input, String expected){
        // given
        DigitString digitString = new DigitString(input);

        // when
        String result = digitString.unique();

        // then
        assertThat(result).contains(expected);
    }

    @DisplayName("숫자가 아닌 입력")
    @ParameterizedTest
    @ValueSource(strings = {"DFD33", "11K", "."})
    void noDigitStringTest(String noDigitInput){
        // then
        assertThatThrownBy(()->{
            // when
            new DigitString(noDigitInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
