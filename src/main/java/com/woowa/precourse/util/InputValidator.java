package com.woowa.precourse.util;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
	/* 숫자인지 유효성 검증 */
	public boolean isNumber(String stringBasedNumber) {
		String regExp = "^[0-9]+$";
		if (stringBasedNumber.matches(regExp)) {
			return true;
		}

		throw new RuntimeException("입력된 값이 숫자가 아닙니다.");
	}

	/* 숫자 길이가 3인지 유효성 검증 */
	public boolean isNumberLength(String stringBasedNumber) {
		if (stringBasedNumber.length() == 3) {
			return true;
		}

		throw new RuntimeException("입력된 길이가 유효하지 않습니다.");
	}

	/* 중복된 숫자가 존재하는지 유효성 검증 */
	public boolean isUniqueNumber(int[] convertedNumber) {
		Set<Integer> numberSet = new HashSet<>();

		for (int i = 0; i < convertedNumber.length; i++) {
			numberSet.add(convertedNumber[i]);
		}

		if (numberSet.size() == 3) {
			return true;
		}

		throw new RuntimeException("입력된 값에 중복이 존재합니다.");
	}
}
