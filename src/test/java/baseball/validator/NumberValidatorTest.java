package baseball.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberValidatorTest {
	private NumberValidator numberValidator;

	@BeforeEach
	void setup() {
		numberValidator = new NumberValidator();
	}

	@DisplayName("데이터가 유효한 숫자인지 확인")
	@ParameterizedTest()
	@CsvSource(value = {":false", "123:true", "1W2:false", "102:false", "1324:false", "122:false", "1:false"}, delimiter = ':')
	public void toCheckNumbers(String strNumbers, boolean expected) {
		NumberValidator numberValidator = new NumberValidator();
		boolean isValid = numberValidator.validate(strNumbers);

		assertThat(isValid).isEqualTo(expected);
	}
}
