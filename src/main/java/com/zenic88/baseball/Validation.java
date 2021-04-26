package com.zenic88.baseball;

public class Validation {

	public static boolean isThreeDigitNumber(String num) {
		return num.matches("[1-9]{3}");
	}

	public static boolean isRepeatValidation(String num) {
		return num.equals("1") || num.equals("2");
	}
}
