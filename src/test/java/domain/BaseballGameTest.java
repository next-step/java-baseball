package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.NumberUtils;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BaseballGameTest {

    @ParameterizedTest
    @ValueSource(strings = {"2345", "12", "1"})
    @DisplayName("입력한 숫자 길이가 3보다 크거나 작을 시 예외 발생")
    void whenInputNotValidNumberLengthThenExceptionTest(String numbers) {

        // given
        NumberGenerator numberGenerator = () -> Numbers.of(NumberUtils.toList(numbers));

        // then
        assertNumbersThrowIllegalArgumentException(numberGenerator, "숫자는 3자리 수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "122", "331"})
    @DisplayName("입력한 숫자에 중복이 있을 시 예외 발생")
    void whenInputDuplicatedNumberThenExceptionTest(String numbers) {

        // given
        NumberGenerator numberGenerator = () -> Numbers.of(NumberUtils.toList(numbers));

        // then
        assertNumbersThrowIllegalArgumentException(numberGenerator, "숫자는 서로 다른 수여야 합니다.");
    }

    private void assertNumbersThrowIllegalArgumentException(NumberGenerator numberGenerator, String message) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BaseballGame(numberGenerator))
                .withMessage(message);
    }
}