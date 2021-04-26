package util;

import java.util.HashSet;

public class Validation {
	private static final String MESSAGE_INVALID_VALUE = "입력값이 올바르지 않습니다. 다시 입력해주세요.";

	// 사용자가 입력한 정답의 유효성 검증
	public static boolean isValidAnswer(String userAnswer) {
		if (userAnswer.length() == 3 && isNumeric(userAnswer) && !isDuplicated(userAnswer)) {
			return true;
		}

		System.out.println(MESSAGE_INVALID_VALUE);
		return false;
	}

	// 1부터 9까지의 숫자로 이루어진 문자열인지 검증
	public static boolean isNumeric(String value) {
		return value.matches("^[1-9]+$");
	}

	// 입력된 숫자끼리 서로 중복이 있는지 검증
	public static boolean isDuplicated(String value) {
		char[] valueArray = value.toCharArray();
		HashSet<String> valueSet = new HashSet<>();

		for (char element : valueArray) {
			valueSet.add(String.valueOf(element));
		}

		return valueSet.size() < valueArray.length;
	}

	public static boolean isValidToRestart(String value) {
		if ("1".equals(value) || "2".equals(value)) {
			return true;
		}
		System.out.print(MESSAGE_INVALID_VALUE);
		return false;
	}
}

