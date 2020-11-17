package io.chikeem90.github.service;

import java.util.Arrays;

public class CommonUtil {
	public static boolean isValid(String input) {
		return isNumber(input) && isValidLength(input) && !(isDuplicate(input));
	}

	public static boolean isNumber(String input) {
		if (!input.matches("^[1-9]+$")) {
			InOutputUtil.notNumberInputMsg();
			return false;
		}
		return true;
	}

	public static boolean isValidLength(String input) {
		if (input.length() != 3) {
			InOutputUtil.invalidLengthInputMsg();
			return false;
		}
		return true;
	}

	public static boolean isDuplicate(String input) {
		char[] chars = input.toCharArray();
		Arrays.sort(chars);
		if ((chars[0] == chars[1]) || (chars[1] == chars[2])) {
			InOutputUtil.duplicatedInputMsg();
			return true;
		}
		return false;
	}

	public static boolean isValidInput(String option) {
		if (!option.matches("^[1-2]$")) {
			InOutputUtil.invalidOptionValMsg();
			return false;
		}
		return true;
	}
}
