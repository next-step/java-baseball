package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class BaseBallRandomValueGeneratorTest {

  @Test
  @DisplayName("랜덤 숫자가 1000 보다 작아야한다.")
  void test1000LessThan() throws Exception {
    BaseballRandomValueGenerator randomValue = new BaseballRandomValueGenerator();
    int value = randomValue.getValue();
    assertThat(value).isLessThan(1000);
  }

  @Test
  @DisplayName("랜덤 숫자가 각각 다른 숫자여야한다.")
  void test() throws Exception {
    BaseballRandomValueGenerator randomValue = new BaseballRandomValueGenerator();
    int firstValue = randomValue.firstValue();
    int sencondValue = randomValue.secondValue();
    int thirdValue = randomValue.thirdValue();

    assertThat(randomValue.containsSize(firstValue)).isEqualTo(1);
    assertThat(randomValue.containsSize(sencondValue)).isEqualTo(1);
    assertThat(randomValue.containsSize(thirdValue)).isEqualTo(1);
  }
}
