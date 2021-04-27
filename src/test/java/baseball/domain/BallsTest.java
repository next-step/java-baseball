package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallsTest {

  @DisplayName("숫자가 아닐시 예외처리")
  @Test
  void is_numeric() {
    assertThatThrownBy(() -> new Balls("12a"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("숫자를 입력해야 합니다.");
  }

  @DisplayName("숫자가 3개가 아닐 시 예외처리")
  @ParameterizedTest
  @ValueSource(strings = {"13","12","22","34"})
  void is_number_three(String input) {
    assertThatThrownBy(() -> new Balls(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("숫자 3개를 입력하셔야 합니다.");
  }

  @DisplayName("중복 숫자가 있을시 예외처리")
  @ParameterizedTest
  @ValueSource(strings = {"113","111","121","211"})
  void is_duplicate(String input) {
    assertThatThrownBy(() -> new Balls(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("서로 다른 공이어야 합니다.");
  }

}