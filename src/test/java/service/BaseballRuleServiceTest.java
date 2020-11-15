package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballRuleServiceTest {

  @ParameterizedTest
  @MethodSource("makeInputAndAnswerSample")
  @DisplayName("스트라이크 및 볼 갯수가 맞는지 비교")
  public void 스트라이크_볼_갯수_비교(List<Integer> input, List<Integer> answer, int strikeCount, int ballCount) {
    BaseballRuleService service = new BaseballRuleService(input, answer);
    assertThat(service.getStrikeCount()).isEqualTo(strikeCount);
    assertThat(service.getBallCount(strikeCount)).isEqualTo(ballCount);
  }

  static Stream<Arguments> makeInputAndAnswerSample() {
    return Stream.of(
        Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), 0, 0),
        Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(3, 4, 5), 0, 1),
        Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(3, 9, 1), 0, 2),
        Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2), 0, 3),
        Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 5), 1, 0),
        Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 5), 1, 1),
        Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2), 1, 2),
        Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 5), 2, 0),
        Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), 3, 0)
    );
  }

}
