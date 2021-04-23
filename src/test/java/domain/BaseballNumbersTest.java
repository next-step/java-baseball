package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

class BaseballNumbersTest {

  @RepeatedTest(10)
  void 생성된_BaseballNumbers는_3개의_BaseballNumber를_가지고있다(RepetitionInfo repetitionInfo) {
    BaseballNumbers baseballNumbers = BaseballNumbers.create();
    assertThat(baseballNumbers.getBaseballNumbers().size()).isEqualTo(3);
  }

  @RepeatedTest(10)
  void 생성된_BaseballNumbers는_3개의_서로_다른_BaseballNumber를_가지고있다(RepetitionInfo repetitionInfo) {
    BaseballNumbers baseballNumbers = BaseballNumbers.create();
    Set<BaseballNumber> set = new HashSet<>();

    baseballNumbers.getBaseballNumbers().forEach(baseballNumber -> set.add(baseballNumber));

    assertThat(set.size()).isEqualTo(3);

    System.out.print(repetitionInfo.getCurrentRepetition() + "번째 테스트에 생성된 BaseBallNumbers: {");
    set.forEach(baseballNumber -> System.out.print(" " + baseballNumber.getBallNumber() + " "));
    System.out.println("}");
  }
}