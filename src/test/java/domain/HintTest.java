package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HintTest {

  @ParameterizedTest
  @CsvSource({
      "false, false",
      "false, true"
  })
  void 야구공번호가_존재하지_않다면_낫싱_힌트_타입이_생성된다(boolean isContainsNumber, boolean isExpectedPosition) {
    Hint hint = Hint.create(isContainsNumber, isExpectedPosition);
    assertThat(hint).isEqualTo(Hint.NOTHING);
  }

  @RepeatedTest(5)
  void 야구공번호가_존재하지만_위치는_같지_않다면_볼_힌트_타입이_생성된다() {
    boolean isContainsNumber = true;
    boolean isExpectedPosition = false;
    Hint hint = Hint.create(isContainsNumber, isExpectedPosition);
    assertThat(hint).isEqualTo(Hint.BALL);
  }

  @RepeatedTest(5)
  void 야구공번호가_존재하고_위치도_같다면_스트라이크_힌트_타입이_생성된다() {
    boolean isContainsNumber = true;
    boolean isExpectedPosition = true;
    Hint hint = Hint.create(isContainsNumber, isExpectedPosition);
    assertThat(hint).isEqualTo(Hint.STRIKE);
  }
}