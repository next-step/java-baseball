package org.dhlee.game.baseball.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.dhlee.game.baseball.constant.BaseballConstant;
import org.dhlee.game.baseball.exception.InputNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputNumberValidatorTest {

	@Test
	@DisplayName("입력 글자수 체크 테스트")
	public void checkLengthValidateTest() {
		InputNumberException exception = assertThrows(InputNumberException.class,
			() -> InputNumberValiator.checkLengthValidate("1234"));
		String message = exception.getMessage();
		assertEquals(BaseballConstant.EXCEPTION_MAX_LENGTH, message);
	}

	@Test
	@DisplayName("숫자 포맷 체크 테스트")
	public void checkFormatValidateTest() {
		InputNumberException exception = assertThrows(InputNumberException.class,
			() -> InputNumberValiator.checkFormatValidate("12T"));
		String message = exception.getMessage();
		assertEquals(BaseballConstant.EXCEPTION_NUMBER_FORMAT, message);
	}

	@Test
	@DisplayName("동일 숫자 체크 테스트")
	public void checkHasEqualNumberValidateTest() {
		InputNumberException exception = assertThrows(InputNumberException.class,
			() -> InputNumberValiator.checkHasEqualNumberValidate("122"));
		String message = exception.getMessage();
		assertEquals(BaseballConstant.EXCEPTION_EQAUL_NUMBER, message);
	}
}
