package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class NumberBaseballGameUiUtilTest {

	@ParameterizedTest
	@DisplayName("isValidInput: should return if input is valid")
	@CsvSource(value = {"1111:false", "232:true", "123:true", "34a:false", "12:false", "023:false"}, delimiter = ':')
	void isValidInput_Should_ReturnIfInputIsValid(String input, boolean expected) {
		boolean result = NumberBaseballGameUiUtil.isValidInput(input);
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("isConvertibleToNumber: should return if string is convertible")
	@CsvSource(value = {"1234:true", "123:true", "090:true", "34a:false", "12x:false", "0-3:false"}, delimiter = ':')
	void isConvertibleToNumber_Should_ReturnIfInputIsConvertible(String input, boolean expected) {
		boolean result = NumberBaseballGameUiUtil.isConvertibleToNumber(input);
		assertThat(result).isEqualTo(expected);
	}
}
