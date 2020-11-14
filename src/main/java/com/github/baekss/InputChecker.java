package com.github.baekss;

import java.util.HashSet;

public class InputChecker {

	/**
	 * 입력값이 숫자 형식이 맞는지 체크한다. 이와 다를시 사용자에게 조언을 한다.
	 * @param input 사용자 입력값
	 * @return true (이상 없음을 나타냄)
	 */
	public static boolean checkNumberFormat(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException numberFormatException) {
			throw new NumberFormatException("숫자를 입력해 주세요");
		}
		return true;
	}
	
	/**
	 * 입력값의 길이가 맞는지 체크한다. 이와 다를시 사용자에게 조언을 한다.
	 * @param input 사용자 입력값
	 * @param length 기준 길이
	 * @return true (이상 없음을 나타냄)
	 */
	public static boolean checkInputLength(String input, int length) {
		int inputLength = input.length();
		
		if (inputLength != length) {
			throw new IllegalArgumentException(length + "개의 숫자를 입력해 주세요");
		}
		return true;
	}
	
	/**
	 * 입력값에 유효하지 않은 값이 있는지 체크한다. 이와 다를시 사용자에게 조언을 한다.
	 * @param input 사용자 입력값
	 * @param invalidValue 유효하지 않은 입력값
	 * @return true (이상 없음을 나타냄)
	 */
	public static boolean checkInvalidValue(String input, String invalidValue) {
		if (input.contains(invalidValue)) {
			throw new IllegalArgumentException(invalidValue + "은(는) 입력하실 수 없습니다");
		}
		return true;
	}
	
	/**
	 * 입력값이 서로 다른 값인지 체크한다. 이와 다를시 사용자에게 조언을 한다.
	 * @param input 사용자 입력값
	 * @param length 서로 다른 값임을 검증하기 위해 사용되는 길이
	 * @return true (이상 없음을 나타냄)
	 */
	public static boolean isUniqueEachValue(String input, int length) {
		HashSet<String> set = new HashSet<>();
		
		for (int i = 0; i < input.length(); i++) {
			String value = input.substring(i, i+1);
			set.add(value);
		}
		
		if (set.size() != length) {
			throw new IllegalArgumentException("서로 다른 숫자를 입력해 주세요");
		}
		return true;
	}
}
