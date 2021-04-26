package baseball.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTest {

	@DisplayName("문자열이 숫자 값이 아니면 false 값을 얻는다.")
	@ParameterizedTest
	@ValueSource(strings = { "abc", "test", "baseball" })
	void GetFalseIfStringValueIsNotNumber(String value) {
		assertThat(StringUtils.isNumber(value)).isFalse();
	}

	@DisplayName("문자열이 숫자 값이면 true 값을 얻는다.")
	@ParameterizedTest
	@ValueSource(strings = { "123", "567", "999" })
	void GetTrueIfStringValueIsNumber(String value) {
		assertThat(StringUtils.isNumber(value)).isTrue();
	}

}