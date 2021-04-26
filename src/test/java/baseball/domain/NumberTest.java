package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberTest {

  @Test
  @DisplayName("숫자 래퍼 클래스를 생성한다.")
  void create() {
    // given
    int number = 1;

    // when
    Number actual = Number.create(number);

    // then
    assertThat(actual)
            .isEqualTo(Number.create(1));
  }

  @Test
  @DisplayName("숫자 래퍼 클래스는 1 ~ 9 범위를 허용한 숫자만 허용한다.")
  void create_error() {
    assertThatIllegalArgumentException()
            .isThrownBy(() -> Number.create(0))
            .withMessageMatching("\\d+ 는 허용된 숫자 범위\\(\\d+ ~ \\d+\\)가 아닙니다.");
  }
}