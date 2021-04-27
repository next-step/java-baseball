import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {

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
