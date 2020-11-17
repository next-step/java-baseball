package io.chikeem90.github.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommonUtilTest {
	@Test
	@DisplayName("숫자인지 아닌지 확인 로직 테스트")
	public void isNumberTest() {
		String testNumber1 = "1234";
		String testNumber2 = "dasg123";
		assertThat(CommonUtil.isNumber(testNumber1)).isTrue();
		assertThat(CommonUtil.isNumber(testNumber2)).isFalse();
	}

	@Test
	@DisplayName("3자리인지 아닌지 확인 로직 테스트")
	public void isValidLengthTest() {
		String testNumber1 = "123";
		String testNumber2 = "1234";
		assertThat(CommonUtil.isValidLength(testNumber1)).isTrue();
		assertThat(CommonUtil.isValidLength(testNumber2)).isFalse();
	}

	@Test
	@DisplayName("중복값이 있는지 없는지 확인 로직 테스트")
	public void isDuplicateTest() {
		String testNumber1 = "123";
		String testNumber2 = "111";
		assertThat(CommonUtil.isDuplicate(testNumber1)).isFalse();
		assertThat(CommonUtil.isDuplicate(testNumber2)).isTrue();
	}

	@Test
	@DisplayName("1 또는 2인 숫자인지 확인 로직 테스트")
	public void isValidInputTest() {
		String testNumber1 = "1";
		String testNumber2 = "9";
		assertThat(CommonUtil.isValidInput(testNumber1)).isTrue();
		assertThat(CommonUtil.isValidInput(testNumber2)).isFalse();
	}
}