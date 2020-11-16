package baseball.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseBallInputValidatorTest {

    @DisplayName("정상적인 입력")
    @ParameterizedTest
    @ValueSource(strings = {"123", "954"})
    void input(String input) {
        assertDoesNotThrow(() -> BaseBallInputValidator.validate(input));
    }

    @DisplayName("비정상적인 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1a3", "95", "11223"})
    void Exception_input(String input) {
        assertThrows(IllegalArgumentException.class, () -> BaseBallInputValidator.validate(input));
    }


}