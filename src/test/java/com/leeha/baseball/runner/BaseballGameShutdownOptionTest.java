package com.leeha.baseball.runner;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballGameShutdownOptionTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void exist_ShouldReturnTrueForExistCode(String code) {
        boolean exists = BaseballGameShutdownOption.exists(code);

        assertThat(exists)
            .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "9"})
    void exist_ShouldReturnFalseForNotExistCode(String code) {
        boolean exists = BaseballGameShutdownOption.exists(code);

        assertThat(exists)
            .isFalse();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void exist_ShouldReturnFalseForNullOrEmptyCode(String code) {
        boolean exists = BaseballGameShutdownOption.exists(code);

        assertThat(exists)
            .isFalse();
    }
}
