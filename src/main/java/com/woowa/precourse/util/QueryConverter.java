package com.woowa.precourse.util;

public class QueryConverter {
	private InputValidator inputValidator;

	/* 생성자 */
	public QueryConverter() {
		inputValidator = new InputValidator();
	}

	/* Strin -> int[] 변환 */
	public int[] convert(String stringBasedNumber) {
		int[] convertedNumber = makeStringToIntArray(stringBasedNumber);

		inputValidator.isNumber(stringBasedNumber);
		inputValidator.isNumberLength(stringBasedNumber);
		inputValidator.isUniqueNumber(convertedNumber);

		return convertedNumber;
	}

	/* 문자열을 숫자 배열로 변환 */
	private int[] makeStringToIntArray(String stringBasedNumber) {
		int[] uniqueNumber = new int[stringBasedNumber.length()];

		for (int i = 0; i < stringBasedNumber.length(); i++) {
			int num = stringBasedNumber.charAt(i) - '0';

			uniqueNumber[i] = num;
		}

		return uniqueNumber;
	}
}
