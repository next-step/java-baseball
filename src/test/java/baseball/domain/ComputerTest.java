package baseball.domain;

import baseball.rule.NumbersRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
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
                    .withMessageMatching("베이스 볼 숫자는 중복되지 않는 \\d+ 자릿수 숫자만 허용됩니다."),
            () -> assertThatIllegalArgumentException()
                    .isThrownBy(() -> Computer.generate(() -> Arrays.asList(Number.create(1), Number.create(2))))
                    .withMessageMatching("베이스 볼 숫자는 중복되지 않는 \\d+ 자릿수 숫자만 허용됩니다."));
  }

  @ParameterizedTest
  @MethodSource("resultOfArguments")
  @DisplayName("사용자가 입력한 번호에 맞게 Strike, ball의 갯수를 반환한다.")
  void resultOf(Player player, int countOfStrike, int countOfBall) {
    // given
    Computer computer = Computer.generate(() -> Arrays.asList(Number.create(1), Number.create(2), Number.create(3)));

    // when
    BallRecord ballRecord = computer.resultOf(player);

    // then
    assertAll(
            () -> assertThat(ballRecord.getCount(StrikeZone.STRIKE)).isEqualTo(countOfStrike),
            () -> assertThat(ballRecord.getCount(StrikeZone.BALL)).isEqualTo(countOfBall)
    );
  }

  private static Stream<Arguments> resultOfArguments() {
    return Stream.of(
            Arguments.of(Player.generateNumberString("123"), 3, 0),
            Arguments.of(Player.generateNumberString("124"), 2, 0),
            Arguments.of(Player.generateNumberString("423"), 2, 0),
            Arguments.of(Player.generateNumberString("421"), 1, 1),
            Arguments.of(Player.generateNumberString("542"), 0, 1),
            Arguments.of(Player.generateNumberString("254"), 0, 1),
            Arguments.of(Player.generateNumberString("132"), 1, 2),
            Arguments.of(Player.generateNumberString("321"), 1, 2),
            Arguments.of(Player.generateNumberString("312"), 0, 3)
    );
  }
}