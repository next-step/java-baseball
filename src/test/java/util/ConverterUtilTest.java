package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ui.exception.GamePlayException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static ui.type.GamePlayExceptionType.INPUT_DATA_IS_NOT_VALID;

class ConverterUtilTest {

	@DisplayName("정상적인 Convert 테스트")
	@ParameterizedTest
	@CsvSource(value = {
		"1,1", "100,100"
	})
	void convertStringToIntegerTest(String value, Integer expect){
		// given

		// when
		Integer actual = ConverterUtil.convertStringToInteger(value);

		// then
		assertThat(actual).isEqualTo(expect);
	}

	@DisplayName("기대값이 같지 않은 테스트")
	@ParameterizedTest
	@CsvSource(value = {
		"1,2", "100,101", "200, 300"
	})
	void convertStringToIntegerFailedTest(String value, Integer expect){
		// given

		// when
		Integer actual = ConverterUtil.convertStringToInteger(value);

		// then
		assertThat(actual).isNotEqualTo(expect);
	}

	@DisplayName("숫자 포멧이 아닌 형태로 Exception 테스트")
	@ParameterizedTest
	@ValueSource(strings = {
		"hi", "hello", "pre", "course", "1st"
	})
	void convertStringToIntegerExceptionTest(String value){
		assertThatThrownBy(()->ConverterUtil.convertStringToInteger(value))
			.isInstanceOf(GamePlayException.class)
			.hasMessageContaining(INPUT_DATA_IS_NOT_VALID.getMessage());
	}
}
