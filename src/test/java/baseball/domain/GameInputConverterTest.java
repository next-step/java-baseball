package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.domain.exception.InvalidGameInputException;

class GameInputConverterTest {
	@DisplayName("유효하지 않은 값을 입력시 에러 발생")
	@ParameterizedTest
	@ValueSource(strings = {"111", "abc", "1ab", "1", "1234", "012"})
	void testInvalidInput(String input) {
		// Given
		int fixedLength = 3;
		// When
		// Then
		assertThatExceptionOfType(InvalidGameInputException.class)
			.isThrownBy(() -> GameInputConverter.convertInputToGameNumbers(input, fixedLength));
	}

	@DisplayName("유효한 값을 입력하였을 경우")
	@Test
	void testValidInput() {
		// Given
		GameNumbers gameNumbers = GameInputConverter.convertInputToGameNumbers("123", 3);
		List<Integer> compareNumbers = Arrays.asList(1, 2, 3);

		// When
		// Then
		assertThat(gameNumbers.equals(new GameNumbers(compareNumbers))).isTrue();
	}
}
