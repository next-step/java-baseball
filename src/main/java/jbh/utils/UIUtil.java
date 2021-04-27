package jbh.utils;

import java.util.HashSet;
import java.util.Set;

public class UIUtil {

	public boolean isWrongMenuNumber(String input) {
		if (input.equals("1") || input.equals("2")) {
			return false;
		}
		System.out.println("입력값이 유효하지 않습니다.");
		return true;
	}

	public boolean isWrongBallNumbers(String input, int length) {
		if (input.length() != length || hasCharacterOutOfRange(input) || hasDuplicateCharacter(input)) {
			System.out.println("입력값이 유효하지 않습니다.");
			return true;
		}
		return false;
	}

	public boolean hasDuplicateCharacter(String input) {
		Set<Character> validSet = new HashSet<>();
		for (char c : input.toCharArray()) {
			validSet.add(c);
		}
		return validSet.size() < input.length();
	}

	public boolean hasCharacterOutOfRange(String input) {
		boolean result = false;
		for (char c : input.toCharArray()) {
			result |= c - '0' > 9 || c - '0' < 1;
		}
		return result;
	}
}
