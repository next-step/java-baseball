package com.github.baekss;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputCheckerTest {
	
	@Test
	@DisplayName("입력값 숫자 형식 실패 테스트")
	public void numberFormatFailTest() {
		assertThatThrownBy(() -> InputChecker.checkNumberFormat("1둘3"))
							.isInstanceOf(NumberFormatException.class)
							.hasMessageContaining("숫자를 입력해 주세요");
	}
	
	@Test
	@DisplayName("숫자 입력값 길이 실패 테스트")
	public void inputLengthFailTest() {
		int length = 3;
		assertThatThrownBy(() -> InputChecker.checkInputLength("12345", length))
							.isInstanceOf(IllegalArgumentException.class)
							.hasMessageContaining("개의 숫자를 입력해 주세요");
	}
	
	@Test
	@DisplayName("유효한 입력값 실패 테스트")
	public void invalidValueFailTest() {
		String invalidValue = "0";
		assertThatThrownBy(() -> InputChecker.checkInvalidValue("560", invalidValue))
							.isInstanceOf(IllegalArgumentException.class)
							.hasMessageContaining("은(는) 입력하실 수 없습니다");
	}
	
	@Test
	@DisplayName("서로 다른 입력값 실패 테스트")
	public void uniqueEachValueFailTest() {
		int length = 3;
		assertThatThrownBy(() -> InputChecker.isUniqueEachValue("955", length))
							.isInstanceOf(IllegalArgumentException.class)
							.hasMessageContaining("서로 다른 숫자를 입력해 주세요");
	}
}
