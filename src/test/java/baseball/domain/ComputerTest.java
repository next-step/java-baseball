package baseball.domain;

import baseball.rule.NumbersRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class ComputerTest {

  @Test
  @DisplayName("컴퓨터는 3자리 숫자를 가지를 생성한다.")
  void generate() {
    // given
    NumbersRule rule = () -> Arrays.asList(Number.create(1),
            Number.create(2),
            Number.create(3));

    // when
    Computer computer = Computer.generate(rule);

    // then
    assertThat(computer.getValues())
            .containsExactly(Number.create(1), Number.create(2), Number.create(3));
  }

  @Test
  @DisplayName("컴퓨터는 null이거나 지정된 자릿수가 아니면 예외가 발생한다.")
  void generate_error() {
    assertAll(() -> assertThatIllegalArgumentException()
                      .isThrownBy(() -> Computer.generate(() -> null))
                      .withMessageMatching("\\d+ 자릿수가 아닙니다."),
              () -> assertThatIllegalArgumentException()
                      .isThrownBy(() -> Computer.generate(() -> Arrays.asList(Number.create(1), Number.create(2))))
                      .withMessageMatching("\\d+ 자릿수가 아닙니다."));
  }

  @ParameterizedTest
  @MethodSource("resultOfArguments")
  @DisplayName("사용자가 입력한 번호에 맞게 Strike, ball의 갯수를 반환한다.")
  void resultOf(List<Number> playerNumbers, int countOfStrike, int countOfBall) {
    // given
    Computer computer = Computer.generate(() -> Arrays.asList(Number.create(1), Number.create(2), Number.create(3)));

    // when
    Map<StrikeZone, Integer> strikeZoneMap = computer.resultOf(playerNumbers);

    // then
    assertAll(
            () -> assertThat(strikeZoneMap.getOrDefault(StrikeZone.STRIKE, 0)).isEqualTo(countOfStrike),
            () -> assertThat(strikeZoneMap.getOrDefault(StrikeZone.BALL, 0)).isEqualTo(countOfBall)
    );
  }

  private static Stream<Arguments> resultOfArguments() {
    return Stream.of(
            Arguments.of(Arrays.asList(Number.create(1), Number.create(2), Number.create(3)), 3, 0),
            Arguments.of(Arrays.asList(Number.create(1), Number.create(2), Number.create(4)), 2, 0),
            Arguments.of(Arrays.asList(Number.create(4), Number.create(2), Number.create(3)), 2, 0),
            Arguments.of(Arrays.asList(Number.create(4), Number.create(2), Number.create(1)), 1, 1),
            Arguments.of(Arrays.asList(Number.create(5), Number.create(4), Number.create(2)), 0, 1),
            Arguments.of(Arrays.asList(Number.create(2), Number.create(5), Number.create(4)), 0, 1),
            Arguments.of(Arrays.asList(Number.create(1), Number.create(3), Number.create(2)), 1, 2),
            Arguments.of(Arrays.asList(Number.create(3), Number.create(2), Number.create(1)), 1, 2),
            Arguments.of(Arrays.asList(Number.create(3), Number.create(1), Number.create(2)), 0, 3)
    );
  }
}