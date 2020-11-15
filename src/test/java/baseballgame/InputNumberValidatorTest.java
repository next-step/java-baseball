package baseballgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputNumberValidatorTest {
    InputNumberValidator validator = new InputNumberValidator();

    @Test
    @DisplayName("입력 받은 세자리 수에 0이 들어가면 error")
    void input_contains_0_then_exception() {
        String testString = "023";
        List<String> errors = validator.validate(testString);
        assertThat(errors.contains("0을 입력 할 수 없습니다")).isTrue();
    }

    @Test
    @DisplayName("입력 받은 세자리 수에 같은 값이 있으면 error")
    void input_contains_same_number_then_exception() {
        String testString = "434";
        List<String> errors = validator.validate(testString);
        assertThat(errors.contains("서로 다른 세자리 수를 입력해 주세요")).isTrue();
    }

    @Test
    @DisplayName("입력 받은 값이 네자리면 error")
    void inputdigit_over3_then_exception() {
        String testString = "1463";
        List<String> errors = validator.validate(testString);
        assertThat(errors.contains("세 자릿수보다 많습니다. 세 자릿수를 입력해 주세요")).isTrue();
    }

    @Test
    @DisplayName("입력 받은 값이 한자리면 error")
    void inputdigit_under3_then_exception() {
        String testString = "3";
        List<String> errors = validator.validate(testString);
        assertThat(errors.contains("세 자릿수보다 적습니다. 세 자릿수를 입력해 주세요")).isTrue();
    }

    @Test
    @DisplayName("입력 받은 값이 숫자가 아니면 error")
    void input_contains_char_then_exception() {
        String testString = "d26";
        List<String> errors = validator.validate(testString);
        assertThat(errors.contains("숫자만 입력 가능합니다")).isTrue();
    }
}