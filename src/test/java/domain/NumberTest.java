package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "10"})
    @DisplayName("입력값에 숫자가 아닌 값이 있거나 유효범위를 벗어난 숫자가 있는 경우 예외 발생")
    void whenInputNotValidNumberThenExceptionTest(int number) {

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Number.of(number, 0))
                .withMessage("숫자는 1 ~ 9 사이의 수여야 합니다.");
    }
}