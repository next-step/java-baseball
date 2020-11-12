package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameHintTest {
	@DisplayName("스트라이크 갯수를 센다.")
	@ParameterizedTest
	@CsvSource(value = {"456:0", "425:1", "423:2"}, delimiter = ':')
	public void countStrike(String input, int count) throws Exception {
		// Given
		String answer = "123";

		// When
		GameHint gameHint = new GameHint(answer, input);

		// Then
		assertThat(gameHint.countStrike()).isEqualTo(count);
	}
}
