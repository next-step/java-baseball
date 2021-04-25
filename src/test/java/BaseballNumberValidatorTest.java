import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseballNumberValidatorTest {


    @ParameterizedTest
    @DisplayName("입력값이 3자리가 아니거나 숫자가 아니거나 각 값이 모두 다르지 않으면 실패")
    @ValueSource(strings = {"12", "12a", "abc", "", "112", "313"})
    void testIsValidNumber(String number) {
        BaseballNumberValidator baseballNumberValidator = new BaseballNumberValidator();
        Boolean isValid = baseballNumberValidator.validateNumber(number);
        assertFalse(isValid);
    }

    @ParameterizedTest
    @DisplayName("리셋의 입력값은 1,2 중 하나여야 함")
    @ValueSource(strings = {"1", "2"})
    void testResetInput(String type) {
        BaseballNumberValidator baseballNumberValidator = new BaseballNumberValidator();
        boolean validResetInput = baseballNumberValidator.isValidResetInput(type);
        assertTrue(validResetInput);
    }

}