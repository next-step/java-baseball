package app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidatorTest {

    @Test
    @DisplayName("입력값이 숫자인지 아닌지 판별")
    void isNumber() {
        String input = "TEST";
        assertThat(InputValidator.isValid(input)).isFalse();
    }

    @Test
    @DisplayName("입력값이 3자리를 넘는지 판별")
    void inputLength() {
        String input = "123456789";
        assertThat(InputValidator.isValid(input)).isFalse();
    }
}