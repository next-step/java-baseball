import baseball.AbnormalInputException;
import baseball.InputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    @Test()
    void validateGuessInput_ShouldThrowForWrongDigit() {
        Assertions.assertThrows(AbnormalInputException.class, () -> {
            InputValidator.validateGuessInput("12s");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234"})
    void validateGuessInput_ShouldThrowForWrongLengthDigit(String input) {
        Assertions.assertThrows(AbnormalInputException.class, () -> {
            InputValidator.validateGuessInput(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void validateGuessInput_ShouldNotThrowForThreeDigit(String input) {
        InputValidator.validateGuessInput(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "a", "123"})
    void validateModeInput_ShouldThrowForNotExpectedInput(String input) {
        Assertions.assertThrows(AbnormalInputException.class, () -> {
            InputValidator.validatePendingInput(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void validateModeInput_ShouldNotThrowForExpectedInput(String input) {
        InputValidator.validatePendingInput(input);
    }
}
