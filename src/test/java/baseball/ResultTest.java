package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultTest {
  private Checker checker;

  @BeforeEach
  void init() {
    List<Integer> answer = Arrays.asList(new Integer[] {4, 2, 9});
    checker = new Checker(answer);
  }

  @ParameterizedTest
  @MethodSource("generateStrikeJudgeData")
  @DisplayName("[Result] 스트라이크 판정 기능 테스트")
  public void isStrike(int[] input, boolean expected) {
    Result result = checker.getScore(input);
    assertThat(result.isAnswer()).isEqualTo(expected);
  }

  static Stream<Arguments> generateStrikeJudgeData() {
    return Stream.of(
        Arguments.of(new int[]{4, 5, 8}, false),
        Arguments.of(new int[]{4, 2, 1}, false),
        Arguments.of(new int[]{4, 2, 9}, true)
    );
  }
}
