/*
 * @(#) BaseBallGameValidator.java 2021. 04. 24.
 *
 */
package com.tistory.ddoriya;

import com.tistory.ddoriya.constants.GameRule;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 이상준
 */
public class BaseBallGameValidator {
	//유저의 Input값을 체크.
	public static boolean isUserNumberValid(String input) {
		return isSizeValid(input) && isNumberValid(input);
	}

	//유저의 Input값의 사이즈를 체크
	public static boolean isSizeValid(String input) {
		Set<Character> setTemp = new HashSet<>();

		for (Character character : input.toCharArray()) {
			setTemp.add(character);
		}
		return setTemp.size() == GameRule.MAX_SIZE && input.length() == GameRule.MAX_SIZE;
	}

	//input의 숫자인지 체크
	public static boolean isNumberValid(String input) {
		String regExp = "^[1-9]+$";
		return input.matches(regExp);
	}

	//input의 1, 2값을 체크
	public static boolean isInputGameStatusValid(String input) {
		return "1".equals(input) || "2".equals(input);
	}
}
