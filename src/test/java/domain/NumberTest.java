package domain;

import exception.BaseBallGameFailureException;
import exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "10"})
    @DisplayName("입력값에 숫자가 아닌 값이 있거나 유효범위를 벗어난 숫자가 있는 경우 예외 발생")
    void whenInputNotValidNumberThenExceptionTest(int number) {

        // then
        assertThatExceptionOfType(BaseBallGameFailureException.class)
                .isThrownBy(() -> Number.of(number, 0))
                .withMessageContaining(ErrorCode.NUMBER_BOUNDARY_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "4", "9"})
    @DisplayName("number 필드값이 같으면 position 이 달라도 eqauls() true 반환")
    void whenSameNumberThenEqualsTrueTest(String inputNumber) {

        // given
        Number numberWithDifferentPosition = Number.of(Integer.parseInt(inputNumber), 1);
        Number numberWithSamePosition = Number.of(Integer.parseInt(inputNumber), 0);

        // when
        Number number = Number.of(inputNumber, 0);

        // then
        assertThat(number.equals(numberWithDifferentPosition)).isTrue();
        assertThat(number).doesNotHaveSameHashCodeAs(numberWithDifferentPosition);
        assertThat(number).hasSameHashCodeAs(numberWithSamePosition);
    }
}