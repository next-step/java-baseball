package precourse.game;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberStringTest {

	@DisplayName("객체 생성 시 문자열이 0을 포함하지 않는 3자리 숫자라면 예외가 발생하지 않는다.")
	@ParameterizedTest(name = "입력값 : {0}")
	@ValueSource(strings = {"123", "456", "789"})
	void validNumberString(String numberString) {
		assertDoesNotThrow(() -> new BaseballNumberString(numberString));
	}

	@DisplayName("객체 생성 시 유효하지 않은 문자열을 전달하면 예외가 발생한다.")
	@ParameterizedTest(name = "문자열 : {0}")
	@ValueSource(strings = {"012", "abc", "a1b", "!@#"})
	void invalidNumberString(String numberString) {
		assertThatIllegalArgumentException().isThrownBy(() -> new BaseballNumberString(numberString));
	}

}