package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

  @DisplayName("Ball 생성")
  @Test
  void create() {
    Ball ball = new Ball(3);
    assertThat(ball).isEqualTo(new Ball(3));
  }

  @DisplayName("1이상 9이하 숫자가 아니면 예외처리")
  @ParameterizedTest
  @ValueSource(ints = {0,10,11})
  void number_range(Integer input) {
    assertThatThrownBy(() -> new Ball(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("1이상 9이하 숫자를 입력해주세요.");
  }

}