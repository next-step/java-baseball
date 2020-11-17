package com.sang5c.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

class NumberTest {

    @DisplayName("숫자는 1부터 9까지 생성 가능하다")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 9
    })
    public void validRange(int number) {
        assertThatCode(() -> new Number(number)).doesNotThrowAnyException();
    }

}
