package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeZoneTest {

  @ParameterizedTest
  @MethodSource("valueOfArguments")
  @DisplayName("같은 숫자가 존재하고, 자릿수가 맞으면 STRIKE," +
          "같은 숫자가 존재하고, 자릿수가 맞지 않으면 BALL," +
          "그외 MISS를 반환한다.")
  void valueOf(boolean existNumber, boolean sameDigit, StrikeZone expected) {
    assertThat(StrikeZone.valueOf(existNumber, sameDigit))
            .isEqualTo(expected);
  }

  private static Stream<Arguments> valueOfArguments() {
    return Stream.of(
            Arguments.of(true, true, StrikeZone.STRIKE),
            Arguments.of(true, false, StrikeZone.BALL),
            Arguments.of(false, false, StrikeZone.MISS)
    );
  }
}