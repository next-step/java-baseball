package domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumbersTest {

  @RepeatedTest(10)
  void 생성된_BaseballNumbers는_3개의_BaseballNumber를_가지고있다(RepetitionInfo repetitionInfo) {
    BaseballNumbers baseballNumbers = BaseballNumbers.create();
    assertThat(baseballNumbers.size()).isEqualTo(3);
  }

  @RepeatedTest(10)
  void 랜덤으로_생성된_BaseballNumbers는_3개의_서로_다른_BaseballNumber를_가지고있다(RepetitionInfo repetitionInfo) {
    BaseballNumbers baseballNumbers = BaseballNumbers.create();
    Set<BaseballNumber> set = new HashSet<>();

    baseballNumbers.getBaseballNumbers().forEach(baseballNumber -> set.add(baseballNumber));

    assertThat(set.size()).isEqualTo(3);

    System.out.print(repetitionInfo.getCurrentRepetition() + "번째 테스트에 생성된 BaseBallNumbers: {");
    set.forEach(baseballNumber -> System.out.print(" " + baseballNumber.getBallNumber() + " "));
    System.out.println("}");
  }

  @ParameterizedTest
  @CsvSource({
      "1, 2, 1",
      "4, 4, 5",
      "5, 5, 5",
      "7, 8, 8",
      "7, 7, 7",
  })
  void 중복된_야구공번호로_BaseballNumbers를_생성하려고하면_예외가_발생한다(int baseballNumber1, int baseballNumber2,
      int baseballNumber3) {
    Throwable exception = assertThrows(IllegalArgumentException.class,
        () -> BaseballNumbers.from(asList(baseballNumber1, baseballNumber2, baseballNumber3)));

    assertThat(exception.getMessage()).isEqualTo("야구공은 서로 다른수로 이루어져야만 합니다.");
  }

  @Test
  void 숫자형태의리스트를_인자로_BaseballNumbers를_생성할수있다() {
    BaseballNumbers baseballNumbers = BaseballNumbers.from(asList(1, 2, 3));
    assertThat(baseballNumbers.getBaseballNumbers().get(0)).isEqualTo(BaseballNumber.from(1));
    assertThat(baseballNumbers.getBaseballNumbers().get(1)).isEqualTo(BaseballNumber.from(2));
    assertThat(baseballNumbers.getBaseballNumbers().get(2)).isEqualTo(BaseballNumber.from(3));
  }

  @ParameterizedTest
  @ValueSource(ints = {
      4, 5, 6, 7, 8, 9, 10
  })
  void 숫자형태의리스트로_BaseballNumbers를_생성할_때_리스트의사이즈가_3보다크면_예외가발생한다(int size) {
    List<Integer> testTokens = new ArrayList<>();

    for (int i = 1; i <= size; i++) {
      testTokens.add(i);
    }

    assertThrows(IllegalArgumentException.class, () -> {
      BaseballNumbers.from(testTokens);
    });
  }
}