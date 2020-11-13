package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.validator.InputNumbersValidator.GAME_NUMBER_COUNT;
import static baseball.validator.InputNumbersValidator.INVALID_INPUT_NUMBERS_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputNumbersTest {

    @DisplayName("from() 테스트")
    @ParameterizedTest(name = "({index}) {displayName} input={0}")
    @ValueSource(strings = {"123", "456", "789"})
    void from(String input) {
        InputNumbers inputNumbers = InputNumbers.from(input.toCharArray());

        assertThat(inputNumbers.size()).isEqualTo(GAME_NUMBER_COUNT);

        for (int i = 0; i < GAME_NUMBER_COUNT; ++i) {
            assertThat(inputNumbers.get(i)).isEqualTo(GameNumber.getInstance(input.charAt(i) - '0'));
        }
    }

    @DisplayName("from() 테스트 - 입력 값 길이가 잘못된 케이스")
    @ParameterizedTest(name = "({index}) {displayName} input={0}")
    @ValueSource(strings = {"1", "12", "1234", "12345", "123456"})
    void fromForInvalidCases(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputNumbers.from(input.toCharArray()));

        assertThat(exception.getMessage()).isEqualTo(INVALID_INPUT_NUMBERS_MESSAGE);
    }

    @DisplayName("from() 테스트 - 입력 값이 null, blank 인 케이스")
    @Test
    void fromForNullAndEmptyCases() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputNumbers.from(null));
        assertThat(exception.getMessage()).isEqualTo(INVALID_INPUT_NUMBERS_MESSAGE);

        exception = assertThrows(IllegalArgumentException.class, () -> InputNumbers.from("".toCharArray()));
        assertThat(exception.getMessage()).isEqualTo(INVALID_INPUT_NUMBERS_MESSAGE);
    }
}