package study;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ScoreBoardTest {
	private final ScoreBoard scoreBoard = new ScoreBoard();

	@ParameterizedTest
	@MethodSource({"baseballScenario1", "baseballScenario2"})
	void testStrike(List<Integer> pitches, List<Integer> swings, int expectedStrike, int expectedBall) {
		Score score = scoreBoard.countScore(swings, pitches);
		assertThat(score.getStrike()).isEqualTo(expectedStrike);
		assertThat(score.getBall()).isEqualTo(expectedBall);
	}

	private static Stream<Arguments> baseballScenario1() {
		return Stream.of(
			Arguments.of(Arrays.asList(9, 8, 7), Arrays.asList(7, 8, 9), 1, 2),
			Arguments.of(Arrays.asList(9, 8, 7), Arrays.asList(7, 9, 8), 0, 3),
			Arguments.of(Arrays.asList(9, 8, 7), Arrays.asList(8, 7, 9), 0, 3),
			Arguments.of(Arrays.asList(9, 8, 7), Arrays.asList(9, 8, 7), 3, 0)
		);
	}

	private static Stream<Arguments> baseballScenario2() {
		return Stream.of(
			Arguments.of(Arrays.asList(8, 2, 5), Arrays.asList(1, 2, 3), 1, 0),
			Arguments.of(Arrays.asList(8, 2, 5), Arrays.asList(4, 5, 6), 0, 1),
			Arguments.of(Arrays.asList(8, 2, 5), Arrays.asList(7, 8, 9), 0, 1),
			Arguments.of(Arrays.asList(8, 2, 5), Arrays.asList(1, 4, 7), 0, 0),
			Arguments.of(Arrays.asList(8, 2, 5), Arrays.asList(5, 2, 8), 1, 2),
			Arguments.of(Arrays.asList(8, 2, 5), Arrays.asList(8, 2, 5), 3, 0)
		);
	}
}
