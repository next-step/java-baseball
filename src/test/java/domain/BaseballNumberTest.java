package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

  @ParameterizedTest
  @ValueSource(ints = {
      1, 2, 3, 4, 5, 6, 7, 8, 9
  })
  void BaseBallNumber는_1부터_9까지의_범위만_허용하고_같은_숫자로_생성된_객체는같다(int ballNumber) {
    BaseballNumber baseballNumber = BaseballNumber.from(ballNumber);
    BaseballNumber baseballNumber2 = BaseballNumber.from(ballNumber);
    assertThat(baseballNumber).isEqualTo(baseballNumber2);
  }

  @ParameterizedTest
  @ValueSource(ints = {
      -1, 0, 10, 100, 1000, -100
  })
  void BaseBallNumber는_1부터_9까지의_범위_밖의_값으로_생성하려고_하면_예외가_발생한다(int ballNumber) {
    assertThrows(IllegalArgumentException.class, () -> {
      BaseballNumber.from(ballNumber);
    });
  }
}