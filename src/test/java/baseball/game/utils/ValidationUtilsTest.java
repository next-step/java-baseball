package baseball.game.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author 박준영
 **/
class ValidationUtilsTest {

	@ParameterizedTest
	@DisplayName("입력 받을시 숫자면 true, 숫자가 아니면 false")
	@CsvSource(value = {"123:true", "abc:false"}, delimiter = ':')
	void isValidNumber(String input, boolean expected) {
		assertThat(ValidationUtils.isValidNumber(input)).isEqualTo(expected);
	}

	@Test
	@DisplayName("입력받은 문자열의 길이와 파라미터로 받은 기준 길이와 같은지 확인")
	void checkNumberLengh() {
		assertThat(ValidationUtils.checkNumberLengh("123", 3)).isEqualTo(true);
		assertThat(ValidationUtils.checkNumberLengh("12", 2)).isEqualTo(true);
		assertThat(ValidationUtils.checkNumberLengh("1234", 4)).isEqualTo(true);
		assertThat(ValidationUtils.checkNumberLengh("1235", 5)).isEqualTo(false);
	}
}