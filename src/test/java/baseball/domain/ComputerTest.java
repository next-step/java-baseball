package baseball.domain;

import baseball.rule.NumbersRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

  @Test
  @DisplayName("컴퓨터(포수)는 3자리 숫자를 가지를 생성한다.")
  void generate() {
    // given
    NumbersRule rule = () -> Arrays.asList(1, 2, 3);

    // when
    Computer computer = Computer.generate(rule);

    // then
    assertThat(computer.getValues())
            .containsExactly(1, 2, 3);
  }
}