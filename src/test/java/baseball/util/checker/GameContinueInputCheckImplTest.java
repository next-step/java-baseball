package baseball.util.checker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameContinueInputCheckImplTest {

	@DisplayName("유효한 입력 체크")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2"})
	void checkValidInput(String input) {
		//given
		InputChecker checker = new GameContinueInputCheckImpl();

		//when
		boolean isValid = checker.check(input);

		//then
		Assertions.assertTrue(isValid);
	}

	@DisplayName("유효하지 않은 입력 체크")
	@ParameterizedTest
	@ValueSource(strings = {"aa", "0", "3", "11", "21"})
	void checkInvalidInput(String input) {
		//given
		InputChecker checker = new GameContinueInputCheckImpl();

		//when
		boolean isValid = checker.check(input);

		//then
		Assertions.assertFalse(isValid);
	}
}