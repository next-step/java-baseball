import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BaseballGameTest {

	private BaseballGame baseballGame;

	@BeforeEach
	public void setup() {
		baseballGame = new BaseballGame();
	}

	@Nested
	@DisplayName("Strike Test")
	class StrikeTest {
		@ParameterizedTest
		@CsvSource({
			"1, 5, false",
			"1, 1, true"
		})
		void testIsStrike(char input, char randomNumber, boolean actualResult) {
			boolean result = baseballGame.isStrike(input, randomNumber);

			assertThat(actualResult).isEqualTo(result);
		}
	}


	@Nested
	@DisplayName("Ball Test")
	class BallTest {
		@ParameterizedTest
		@CsvSource({
			"1, 125, true",
			"9, 391, true",
			"7, 247, true",
			"1, 825, false"
		})
		void testIsBall(char input, String randomNumbers, boolean actualResult) {

			boolean result = baseballGame.isBall(input, randomNumbers);

			assertThat(actualResult).isEqualTo(result);
		}
	}


	@Nested
	@DisplayName("GetScore Test")
	class GetScoreTest {
		@ParameterizedTest
		@CsvSource({
			"123, 825, 0, 1",
			"564, 456, 3, 0",
			"623, 561, 1, 0",
			"893, 893, 0, 3"
		})
		void testGetScore(String input, String randomNumbers, int ballCount, int strikeCount) {

			Score result = baseballGame.getScore(input, randomNumbers);

			assertThat(ballCount).isEqualTo(result.getBallCount());
			assertThat(strikeCount).isEqualTo(result.getStrikeCount());
		}
	}


	@Nested
	@DisplayName("GamePass Test")
	class GamePassTest {
		@ParameterizedTest
		@CsvSource({
			"0, 0, false",
			"1, 2, false",
			"3, 0, false",
			"0, 3, true"
		})
		void testIsGamePass(int ballCount, int strikeCount, boolean actualResult) {
			Score score = new Score(ballCount,strikeCount);

			assertThat(actualResult).isEqualTo(baseballGame.isGamePass(score));
		}
	}

}
