import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {

	@Nested
	@DisplayName("Strike Test")
	class StrikeTest {
		@Test
		@DisplayName("Strike Test 1")
		void testIsStrike() {

			BaseballGame baseballGame = new BaseballGame();
			char input = '1';

			char randomNumber = '5';

			boolean result = baseballGame.isStrike(input, randomNumber);

			assertThat(false).isEqualTo(result);
		}

		@Test
		@DisplayName("Strike Test 2")
		void testIsStrike2() {

			BaseballGame baseballGame = new BaseballGame();
			char input = '1';
			char randomNumber = '1';

			boolean result = baseballGame.isStrike(input, randomNumber);

			assertThat(true).isEqualTo(result);
		}
	}


	@Nested
	@DisplayName("Ball Test")
	class BallTest {
		@Test
		@DisplayName("Ball Test 1")
		void testIsBall() {
			BaseballGame baseballGame = new BaseballGame();
			char input = '1';
			String randomNumbers = "125";

			boolean result = baseballGame.isBall(input, randomNumbers);

			assertThat(true).isEqualTo(result);
		}

		@Test
		@DisplayName("Ball Test 2")
		void testIsBall2() {
			BaseballGame baseballGame = new BaseballGame();
			char input = '9';
			String randomNumbers = "391";

			boolean result = baseballGame.isBall(input, randomNumbers);

			assertThat(true).isEqualTo(result);
		}

		@Test
		@DisplayName("Ball Test 3")
		void testIsBall3() {
			BaseballGame baseballGame = new BaseballGame();
			char input = '7';
			String randomNumbers = "247";

			boolean result = baseballGame.isBall(input, randomNumbers);

			assertThat(true).isEqualTo(result);
		}

		@Test
		@DisplayName("Ball Test 4")
		void testIsBall4() {
			BaseballGame baseballGame = new BaseballGame();
			char input = '1';
			String randomNumbers = "825";

			boolean result = baseballGame.isBall(input, randomNumbers);

			assertThat(false).isEqualTo(result);
		}
	}


	@Nested
	@DisplayName("GetScore Test")
	class GetScoreTest {
		@Test
		@DisplayName("GetScore Test 1")
		void testGetScore1() {
			BaseballGame baseballGame = new BaseballGame();
			String input = "123";
			String randomNumbers = "825";

			Score result = baseballGame.getScore(input, randomNumbers);

			assertThat(0).isEqualTo(result.getBallCount());
			assertThat(1).isEqualTo(result.getStrikeCount());
		}

		@Test
		@DisplayName("GetScore Test 2")
		void testGetScore2() {
			BaseballGame baseballGame = new BaseballGame();
			String input = "564";
			String randomNumbers = "456";

			Score result = baseballGame.getScore(input, randomNumbers);

			assertThat(3).isEqualTo(result.getBallCount());
			assertThat(0).isEqualTo(result.getStrikeCount());
		}

		@Test
		@DisplayName("GetScore Test 3")
		void testGetScore3() {
			BaseballGame baseballGame = new BaseballGame();
			String input = "623";
			String randomNumbers = "561";

			Score result = baseballGame.getScore(input, randomNumbers);

			assertThat(1).isEqualTo(result.getBallCount());
			assertThat(0).isEqualTo(result.getStrikeCount());
		}

		@Test
		@DisplayName("GetScore Test 4")
		void testGetScore4() {
			BaseballGame baseballGame = new BaseballGame();
			String input = "893";
			String randomNumbers = "893";

			Score result = baseballGame.getScore(input, randomNumbers);

			assertThat(0).isEqualTo(result.getBallCount());
			assertThat(3).isEqualTo(result.getStrikeCount());
		}
	}


	@Nested
	@DisplayName("GamePass Test")
	class GamePassTest {
		@Test
		@DisplayName("isGamePass Test 1")
		void testIsGamePass() {
			BaseballGame baseballGame = new BaseballGame();
			Score score = new Score(0,0);

			assertThat(false).isEqualTo(baseballGame.isGamePass(score));
		}

		@Test
		@DisplayName("isGamePass Test 2")
		void testIsGamePass2() {
			BaseballGame baseballGame = new BaseballGame();
			Score score = new Score(1,2);

			assertThat(false).isEqualTo(baseballGame.isGamePass(score));
		}

		@Test
		@DisplayName("isGamePass Test3")
		void testIsGamePass3() {
			BaseballGame baseballGame = new BaseballGame();
			Score score = new Score(3,0);

			assertThat(false).isEqualTo(baseballGame.isGamePass(score));
		}

		@Test
		@DisplayName("isGamePass Test4")
		void testIsGamePass4() {
			BaseballGame baseballGame = new BaseballGame();
			Score score = new Score(0,3);

			assertThat(true).isEqualTo(baseballGame.isGamePass(score));
		}
	}

}
