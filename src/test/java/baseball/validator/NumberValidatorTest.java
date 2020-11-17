package baseball.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValidatorTest {
	private NumberValidator numberValidator;

	@BeforeEach
	void setup() {
		numberValidator = new NumberValidator();
	}

	@DisplayName("데이터가 유효하지 않은 숫자 확인")
	@ParameterizedTest()
	@CsvSource(value = {":" + NumberValidator.NULL_MESSAGE, "1W2:유효한 요청 번호가 아닙니다.",
		"102:" + NumberValidator.INVALID_MESSAGE, "1324:" + NumberValidator.INVALID_MESSAGE,
		"122:" + NumberValidator.DUPLICATE_MESSAGE, "1:" + NumberValidator.INVALID_MESSAGE}
		, delimiter = ':'
	)
	public void toCheckInvalidNumbers(String strNumbers, String errorMessage) {
		assertThatIllegalArgumentException().isThrownBy(() -> numberValidator.validate(strNumbers))
			.withMessage(errorMessage)
		;
	}

	@DisplayName("데이터가 유효한 숫자 확인")
	@ParameterizedTest()
	@ValueSource(strings = {"123"})
	public void toCheckValidNumbers(String strNumbers) {
		numberValidator.validate(strNumbers);
	}
}
