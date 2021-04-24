package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

  @ParameterizedTest
  @ValueSource(ints = {0, 9})
  @DisplayName("0~9 사이의 BaseballNumber 를 생성한다.")
  void createNumber(int number) {
    BaseballNumber baseballNumber = new BaseballNumber(number);
    assertEquals(baseballNumber.getNumber(), number);
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 10})
  @DisplayName("0~9 가 아닌 BaseballNumber 를 생성 시, illegalArgumentException 발생")
  void createNumber_fail(int number) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new BaseballNumber(number))
        .withMessage(BaseballNumber.NUMBER_RANGE_ERROR_MESSAGE);
  }
}