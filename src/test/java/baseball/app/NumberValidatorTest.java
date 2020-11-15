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

  private NumberValidator numberValidator;

  @BeforeEach
  public void setUp() {
    numberValidator = new NumberValidator();
  }

  @DisplayName("서로 다른 세자리 수 인지 검증")
  @Test
  public void isDifferentThreeNumber() {
    assertThat(numberValidator.valid(1)).isEqualTo(false);
    assertThat(numberValidator.valid(12)).isEqualTo(false);
    assertThat(numberValidator.valid(100)).isEqualTo(false);
    assertThat(numberValidator.valid(113)).isEqualTo(false);
    assertThat(numberValidator.valid(133)).isEqualTo(false);
    assertThat(numberValidator.valid(313)).isEqualTo(false);
    assertThat(numberValidator.valid(333)).isEqualTo(false);
    assertThat(numberValidator.valid(190)).isEqualTo(false);
    assertThat(numberValidator.valid(110)).isEqualTo(false);
    assertThat(numberValidator.valid(610)).isEqualTo(false);
    assertThat(numberValidator.valid(90)).isEqualTo(false);
    assertThat(numberValidator.valid(123)).isEqualTo(true);
    assertThat(numberValidator.valid(698)).isEqualTo(true);
  }

}
