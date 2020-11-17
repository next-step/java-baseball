package com.sang5c.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NumberTest {

    @DisplayName("숫자는 1부터 9까지 생성 가능하다")
    @ParameterizedTest
    @ValueSource(ints = {
            Number.MIN_NUMBER,
            Number.MAX_NUMBER
    })
    public void validRange(int number) {
        assertThatCode(() -> Number.of(number)).doesNotThrowAnyException();
    }

    @DisplayName("경계값 밖은 exception이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {
            Number.MIN_NUMBER - 1,
            Number.MAX_NUMBER + 1
    })
    public void invalidRange(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> Number.of(number));
    }

    @DisplayName("생성한 객체가 같은 객체이다")
    @Test
    public void caching() {
        assertThat(Number.of(3)).isEqualTo(Number.of(3));
    }

}
