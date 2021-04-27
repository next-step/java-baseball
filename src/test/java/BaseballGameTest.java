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

}
