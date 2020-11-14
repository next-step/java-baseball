package com.woowahan.camp.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidationUtilTest {

	@DisplayName("isNotNumber메서드에 숫자가 아닌 문자열이 입력되면 true를 반환하고, 숫자인 문자가 입력되면 false를 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {":true", "'':true", "A B:true", "2A5:true", "1:false", "123:false", "357:false",
		"017:false"}, delimiter = ':')
	void isNotNumberTest(String value, boolean expected) {
		//Given
		//When
		boolean result = ValidationUtil.isNotNumber(value);

		//Then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("isNotNumber메서드에 숫자가 아닌 문자열이 입력되면 true를 반환하고, 숫자인 문자가 입력되면 false를 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {":true", "'':true", "A B:false", "2A5:false", "1:true", "123:false", "357:false",
		"017:false"}, delimiter = ':')
	void isNotLengthThreeTest(String value, boolean expected) {
		//Given
		//When
		boolean result = ValidationUtil.isNotLengthThree(value);

		//Then
		assertThat(result).isEqualTo(expected);
	}

}