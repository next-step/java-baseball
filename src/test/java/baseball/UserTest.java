package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class UserTest {

  @Test
  @DisplayName("[User] 사용자가 입력한 수를 배열로 바꾸는 기능 테스트")
  void makeArrTest() {
    assertThat(User.stringToArr("123").length).isEqualTo(3);
  }

  @ParameterizedTest
  @MethodSource("validateUserInputData")
  @DisplayName("[User] 사용자 입력에 대한 validation 기능 테스트")
  void validateUserInputTest(String input, boolean expected) {
    assertThat(User.validateUserInput(input)).isEqualTo(expected);
  }

  static Stream<Arguments> validateUserInputData() {
    return Stream.of(
        Arguments.of("123", true),
        Arguments.of("874", true),
        Arguments.of("1234", false),
        Arguments.of("12b", false),
        Arguments.of("1a3", false),
        Arguments.of("abc", false),
        Arguments.of("120", false)
    );
  }
}
