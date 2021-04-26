package com.zenic88.baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ValidationTest {

	@Test
	public void numberValidate() {
		String number = "123";

		assertTrue(Validation.isThreeDigitNumber(number));
	}

	@Test
	public void notNumberValidate() {
		String alphabet = "abc";

		assertFalse(Validation.isThreeDigitNumber(alphabet));
	}

	@Test
	public void digitsValidate() {
		String number = "1234";

		assertFalse(Validation.isThreeDigitNumber(number));
	}

	@Test
	public void oneTwoValidate() {
		String available = "1";
		String notAvailable = "3";

		assertTrue(Validation.isRepeatValidation(available));
		assertFalse(Validation.isRepeatValidation(notAvailable));
	}
}
