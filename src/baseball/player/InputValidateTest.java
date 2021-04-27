package baseball.player;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidateTest {

	@ParameterizedTest
	@DisplayName("잘못된 입력 오류 테스트")
	@ValueSource(strings = {"123", "112", "rsd", "124567", "012"})
	void testValidationChecker(String stringValue) {
		assertThatThrownBy(() -> InputValidate.validationChecker(stringValue))
		.isInstanceOf(Exception.class);
	}

}
