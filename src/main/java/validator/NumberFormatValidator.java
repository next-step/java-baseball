package validator;

import java.util.HashSet;
import java.util.Set;

public class NumberFormatValidator {

	public static void validate(int input) {
		checkHasZero(input);
		checkDifferentNumber(input);
		checkNumberLength(input);
	}

	public static boolean isValidate(int number) {
		return !hasSameNumber(number) && !hasZero(number);
	}

	private static void checkHasZero(int number) {
		if (hasZero(number)) {
			throw new IllegalArgumentException("0을 제외한 숫자를 입력해주세요");
		}
	}

	private static boolean hasZero(String input) {
		return input.contains("0");
	}

	private static boolean hasZero(int number) {
		return hasZero(String.valueOf(number));
	}

	private static boolean hasSameNumber(int random) {
		Set<Integer> numbers = new HashSet<>();
		while (random > 0) {
			numbers.add(random % 10);
			random = random / 10;
		}
		return numbers.size() != 3;
	}

	private static void checkDifferentNumber(int input) {
		if (hasSameNumber(input)) {
			throw new IllegalArgumentException("서로 다른 3자리 숫자로 구성되어야 합니다.");
		}
	}

	private static void checkNumberLength(int input) {
		if (String.valueOf(input).length() != 3) {
			throw new IllegalArgumentException("3자리 숫자로 구성되어야 합니다.");
		}
	}

}
