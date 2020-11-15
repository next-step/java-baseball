package com.jaeeyeonling.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("숫자를 위한 유틸 클래스를 테스트한다.")
class NumbersTest {

    @DisplayName("문자열을 이용하여 숫자 검증을 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "123", "223423423", "9", "999"})
    void isNumberTrueWithString(final String value) {
        // when
        final var isNumber = Numbers.isNumber(value);

        // then
        assertThat(isNumber).isTrue();
    }

    @DisplayName("문자열을 이용하여 숫자 검증을 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "AA", "1sa4", "1235654 6", "", "123'"})
    void isNumberFalseWithString(final String value) {
        // when
        final var isNumber = Numbers.isNumber(value);

        // then
        assertThat(isNumber).isFalse();
    }
}
