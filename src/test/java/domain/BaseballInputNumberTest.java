package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class BaseballInputNumberTest {

  @ParameterizedTest
  @DisplayName("정상 - 정상적인 입력 숫자를 받을 경우")
  @ValueSource(strings = {"123","493","314"})
  public void 정상_케이스(String input) {
    BaseballInputNumber baseballInputNumber = new BaseballInputNumber(input);
    assertThat(baseballInputNumber.getNumberList().size()).isEqualTo(3);
  }

  @Test
  @DisplayName("예외 - 입력이 3자리가 아닌 경우")
  public void 예외_3자리_아닌_경우() {
    String input = "1234";
    assertThatThrownBy(() -> {
      new BaseballInputNumber(input);
    }).isInstanceOf(IllegalArgumentException.class)
      .hasMessage("3자리의 숫자를 입력해주세요.");
  }

  @Test
  @DisplayName("예외 - 1에서 9사이의 숫자가 아닌 경우")
  public void 예외_범위_초과인_경우() {
    String input = "012";
    assertThatThrownBy(() -> {
      new BaseballInputNumber(input);
    }).isInstanceOf(IllegalArgumentException.class)
      .hasMessage("1에서 9사이의 숫자로 입력해주세요.");
  }

  @Test
  @DisplayName("예외 - 서로 다른수가 아닌 경우")
  public void 예외_중복인_경우() {
    String input = "334";
    assertThatThrownBy(() -> {
      new BaseballInputNumber(input);
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("모두 다른 수로 입력해주세요.");
  }

}
