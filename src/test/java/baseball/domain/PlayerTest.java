package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PlayerTest {

  @Test
  @DisplayName("문자열를 통해 게임 플레이어 객체 생성된다.")
  void generateNumberString() {
    // given
    String params = "123";

    // when
    Player actual = Player.generateNumberString(params);

    // then
    assertThat(actual.getValues())
            .containsExactly(Number.create(1),
                    Number.create(2),
                    Number.create(3));
  }

  @Test
  @DisplayName("숫자가 존재하면 true를 반환한다.")
  void existNumber() {
    // given
    Player player = Player.generateNumberString("123");

    // when
    boolean exist = player.existNumber(Number.create(1));
    boolean notFound = player.existNumber(Number.create(4));

    // then
    assertAll(
            () -> assertThat(exist).isTrue(),
            () -> assertThat(notFound).isFalse()
    );
  }

  @Test
  @DisplayName("숫자의 자릿수를 반환한다.")
  void getDigit() {
    // given
    Player player = Player.generateNumberString("123");

    // when
    int digit = player.getDigit(Number.create(1));

    // then
    assertThat(digit).isEqualTo(0);
  }
}