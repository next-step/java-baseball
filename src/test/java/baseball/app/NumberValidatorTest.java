package baseball.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/11/15.
 * @project java-baseball
 * @description
 */
public class NumberValidatorTest {

  @DisplayName("서로 다른 세자리 수 인지 검증")
  @Test
  public void isDifferentThreeNumber() {
    assertThat(isValidNumber(1)).isEqualTo(false);
    assertThat(isValidNumber(12)).isEqualTo(false);
    assertThat(isValidNumber(100)).isEqualTo(false);
    assertThat(isValidNumber(113)).isEqualTo(false);
    assertThat(isValidNumber(133)).isEqualTo(false);
    assertThat(isValidNumber(313)).isEqualTo(false);
    assertThat(isValidNumber(333)).isEqualTo(false);
    assertThat(isValidNumber(190)).isEqualTo(false);
    assertThat(isValidNumber(110)).isEqualTo(false);
    assertThat(isValidNumber(610)).isEqualTo(false);
    assertThat(isValidNumber(90)).isEqualTo(false);
    assertThat(isValidNumber(123)).isEqualTo(true);
    assertThat(isValidNumber(698)).isEqualTo(true);
  }

  private boolean isValidNumber(int number) {
    return NumberValidator.valid(number);
  }

}
