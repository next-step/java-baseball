package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NumberTest {

    @DisplayName("숫자가 아닌 다른 문자가 들어왔을때 에러를 잘 던지는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"c", "cd"})
    void notIntegerTest(String wrongInput) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Number.of(wrongInput));
    }

    @DisplayName("숫자가 1-9 밖 숫자로 들어왔을때 에러를 잘 던지는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "11"})
    void notZeroTest(String wrongInput) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Number.of(wrongInput));
    }
}