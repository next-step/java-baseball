package game.baseball.number.participants.evaluators;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import game.baseball.number.exceptions.InvalidDifferentThreeNumberTypingException;
import game.baseball.number.exceptions.InvalidRestartOrExitInputException;
import game.baseball.number.validator.NumbersValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumbersValidatorTest {

    @ParameterizedTest
    @DisplayName("입력값 유효성 체크 throw")
    @ValueSource(strings = {"1", "a", "@", "#", "", " ", "   ", "  ", "a11", "abc", "11c", "111", "112", "000", "012", "4444", "1234"})
    void testNumbersValidateReturnFalse(String input) {
        NumbersValidator validator = new NumbersValidator();

        assertThatThrownBy(() -> validator.validate(input))
            .isInstanceOf(InvalidDifferentThreeNumberTypingException.class);
    }

    @Test
    @DisplayName("null 입력값 유효성 체크 throw")
    void testNullNumbersValidateReturnFalse() {
        NumbersValidator validator = new NumbersValidator();

        assertThatThrownBy(() -> validator.validate(null))
            .isInstanceOf(InvalidDifferentThreeNumberTypingException.class);
    }

    @ParameterizedTest
    @DisplayName("입력값 유효성 체크 true")
    @ValueSource(strings = {"123", "456"})
    void testNumbersValidateReturnTrue(String input) {
        NumbersValidator validator = new NumbersValidator();

        Assertions.assertTrue(validator.validate(input), "input" + input);
    }
}