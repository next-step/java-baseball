package baseball.domain;

import baseball.rule.NumbersRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class ComputerTest {

  @Test
  @DisplayName("컴퓨터는 3자리 숫자를 가지를 생성한다.")
  void generate() {
    // given
    NumbersRule rule = () -> Arrays.asList(1, 2, 3);

    // when
    Computer computer = Computer.generate(rule);

    // then
    assertThat(computer.getValues())
            .containsExactly(1, 2, 3);
  }

  @Test
  @DisplayName("컴퓨터는 null이거나 지정된 자릿수가 아니면 예외가 발생한다.")
  void generate_error() {
    assertAll(() -> assertThatIllegalArgumentException()
                      .isThrownBy(() -> Computer.generate(() -> null))
                      .withMessageMatching("\\d+ 자릿수가 아닙니다."),
              () -> assertThatIllegalArgumentException()
                      .isThrownBy(() -> Computer.generate(() -> Arrays.asList(1, 2)))
                      .withMessageMatching("\\d+ 자릿수가 아닙니다."));
  }
}