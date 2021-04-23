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
	public static boolean isUserNumberValid(String str) {
		return isSizeValid(str) && isNumberValid(str);
	}

	public static boolean isSizeValid(String str) {
		Set<Character> setTemp = new HashSet<>();

		for (Character character : str.toCharArray()) {
			setTemp.add(character);
		}
		return setTemp.size() == GameRule.MAX_SIZE && str.length() == GameRule.MAX_SIZE;
	}

	public static boolean isNumberValid(String str) {
		String regExp = "^[1-9]+$";
		return str.matches(regExp);
	}

	public static boolean isInputValid(String str) {
		return "1".equals(str) || "2".equals(str);
	}
}
