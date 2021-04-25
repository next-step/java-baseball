package validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberFormatValidatorTest {

  @DisplayName(value = "입력이 숫자가 아닐경우 IllegalArgumentException 을 일으킨다")
  @ParameterizedTest
  @ValueSource(strings = {"1l1", "숫자아님", "/12", "3:5"})
  void inputIsNumber(String input) {
    NumberFormatValidator validator = new NumberFormatValidator();
    assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
  }

  @DisplayName(value = "숫자에 같은 수가 있을 경우 IllegalArgumentException 을 일으킨다")
  @ParameterizedTest
  @ValueSource(strings = {"171", "777"})
  void validateNumber(String input) {
    NumberFormatValidator validator = new NumberFormatValidator();
    assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
  }

  @DisplayName(value = "3자리가 아니면 IllegalArgumentException 을 일으킨다")
  @ParameterizedTest
  @ValueSource(strings = {"9867", "12"})
  void numberLength(String input) {
    NumberFormatValidator validator = new NumberFormatValidator();
    assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
  }

}
