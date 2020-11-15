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

public class CheckerTest {
  private Checker checker;

  @BeforeEach
  void init() {
    List<Integer> answer = Arrays.asList(new Integer[]{4, 2, 9});
    checker = new Checker(answer);
  }

  @ParameterizedTest
  @MethodSource("generateUserInputData")
  @DisplayName("[Checker] 스트라이크/볼 점수 카운트 기능 테스트")
  public void getScore(int[] input, int strikeExp, int ballExp) {
    int strike = checker.getStrikeCount(input);
    int ball = checker.getBallCount(input, strike);
    assertThat(strike).isEqualTo(strikeExp);
    assertThat(ball).isEqualTo(ballExp);
  }

  @ParameterizedTest
  @MethodSource("generateStrikeJudgeData")
  @DisplayName("[Checker] 스트라이크 판정 기능 테스트")
  public void isStrike(int[] input, boolean expected) {
    checker.getScore(input);
    assertThat(checker.checkAnswer()).isEqualTo(expected);
  }


  static Stream<Arguments> generateUserInputData() {
    return Stream.of(
        Arguments.of(new int[]{4, 5, 8}, 1, 0),
        Arguments.of(new int[]{4, 2, 1}, 2, 0),
        Arguments.of(new int[]{4, 2, 9}, 3, 0),
        Arguments.of(new int[]{2, 7, 8}, 0, 1),
        Arguments.of(new int[]{2, 9, 8}, 0, 2),
        Arguments.of(new int[]{2, 9, 4}, 0, 3),
        Arguments.of(new int[]{3, 5, 8}, 0, 0)
    );
  }

  static Stream<Arguments> generateStrikeJudgeData() {
    return Stream.of(
        Arguments.of(new int[]{4, 5, 8}, false),
        Arguments.of(new int[]{4, 2, 1}, false),
        Arguments.of(new int[]{4, 2, 9}, true)
    );
  }
}
