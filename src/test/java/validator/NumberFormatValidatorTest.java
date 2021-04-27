package validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberFormatValidatorTest {

	@DisplayName(value = "숫자에 같은 수가 있을 경우 IllegalArgumentException 을 일으킨다")
	@ParameterizedTest
	@ValueSource(ints = {171, 777})
	void validateNumber(int input) {
		assertIllegalArgumentException(() -> NumberFormatValidator.validate(input));
	}

	@DisplayName(value = "3자리가 아니면 IllegalArgumentException 을 일으킨다")
	@ParameterizedTest
	@ValueSource(ints = {9867, 12})
	void numberLength(int input) {
		assertIllegalArgumentException(() -> NumberFormatValidator.validate(input));
	}

	@DisplayName(value = "입력에 0이 있으면 IllegalArgumentException 을 일으킨다")
	@ParameterizedTest
	@ValueSource(ints = {308, 204, 910})
	void noZero(int input) {
		assertIllegalArgumentException(() -> NumberFormatValidator.validate(input));
	}

	private void assertIllegalArgumentException(Executable executable) {
		assertThrows(IllegalArgumentException.class, executable);
	}

}
