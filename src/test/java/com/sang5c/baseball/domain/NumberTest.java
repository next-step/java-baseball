package com.sang5c.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NumberTest {

    @DisplayName("숫자는 1이상 9이하 정상 생성")
    @ParameterizedTest
    @ValueSource(ints = {
            Number.MIN_NUMBER,
            Number.MAX_NUMBER
    })
    public void validRange(int number) {
        assertThatCode(() -> Number.of(number)).doesNotThrowAnyException();
    }

    @DisplayName("경계값 벗어난 경우 에러")
    @ParameterizedTest
    @ValueSource(ints = {
            Number.MIN_NUMBER - 1,
            Number.MAX_NUMBER + 1
    })
    public void invalidRange(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> Number.of(number));
    }

    @DisplayName("다른 번호와 비교(캐시 적용)")
    @Test
    public void cache() {
        assertThat(Number.of(1)).isEqualTo(Number.of("1"));
    }

    @DisplayName("null 또는 빈 문자열로 생성시 에러")
    @NullAndEmptySource
    @ParameterizedTest
    public void exceptEmptyString(String str) {
        assertThatIllegalArgumentException().isThrownBy(() -> Number.of(str));
    }

}
