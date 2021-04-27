package study;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ScoreTest {
	private static Stream<Arguments> provideScoreTestData() {
		return Stream.of(
			Arguments.of(Score.strike(), Score.strike(), true),
			Arguments.of(Score.strike(), Score.ball(), false),
			Arguments.of(Score.strike(), Score.nothing(), false),
			Arguments.of(Score.ball(), Score.strike(), false),
			Arguments.of(Score.ball(), Score.ball(), true),
			Arguments.of(Score.ball(), Score.nothing(), false),
			Arguments.of(Score.nothing(), Score.strike(), false),
			Arguments.of(Score.nothing(), Score.ball(), false),
			Arguments.of(Score.nothing(), Score.nothing(), true),
			Arguments.of(Score.nothing().sumScore(Score.strike()), Score.strike(), true),
			Arguments.of(Score.nothing().sumScore(Score.strike()), Score.ball(), false),
			Arguments.of(Score.nothing().sumScore(Score.strike()), Score.nothing(), false),
			Arguments.of(Score.ball().sumScore(Score.strike()), Score.strike(), false),
			Arguments.of(Score.ball().sumScore(Score.strike()), Score.ball(), false),
			Arguments.of(Score.ball().sumScore(Score.strike()), Score.nothing(), false),
			Arguments.of(Score.strike().sumScore(Score.strike()), Score.strike(), false),
			Arguments.of(Score.strike().sumScore(Score.strike()).sumScore(Score.strike()), Score.threeStrike(), true)
		);
	}

	@ParameterizedTest
	@MethodSource("provideScoreTestData")
	void testScoreCompare(Score actual, Score expected, boolean isEqualTo) {
		if (isEqualTo) {
			assertThat(actual).isEqualTo(expected);
		} else {
			assertThat(actual).isNotEqualTo(expected);
		}
	}
}
