package baseball.util.checker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballInputCheckerImplTest {

	@DisplayName("유효한 입력 체크")
	@ParameterizedTest
	@ValueSource(strings = {"345", "123", "456"})
	void checkValidInput(String input) {
		//given
		InputChecker checker = new BaseballInputCheckerImpl();

		//when
		boolean isValid = checker.check(input);

		//then
		Assertions.assertTrue(isValid);
	}

	@DisplayName("유효하지 않은 입력 체크")
	@ParameterizedTest
	@ValueSource(strings = {"000", "0", "111", "9999", "abc11"})
	void checkInvalidInput(String input) {
		//given
		InputChecker checker = new BaseballInputCheckerImpl();

		//when
		boolean isValid = checker.check(input);

		//then
		Assertions.assertFalse(isValid);
	}
}