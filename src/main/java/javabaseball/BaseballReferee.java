package javabaseball;

import java.util.HashSet;
import java.util.Set;

public class BaseballReferee {
	private static final int BASEBALL_NUMBER_LENGTH = 3;

	private BaseballReferee() {
	}

	public static BaseballReferee of() {
		return new BaseballReferee();
	}

	public boolean isFair(String inputString) {
		if (inputString.length() != BASEBALL_NUMBER_LENGTH) {
			System.out.print("입력은 " + BASEBALL_NUMBER_LENGTH + " 자리의 숫자입니다. ");
			return false;
		}

		if (!isAllDigitValidRange(inputString)) {
			return false;
		}

		return !hasDuplicatedNumber(inputString);
	}

	public BallCounts decideBalls(String candidate, String target) {
		int strikeCount = 0;
		int ballCount = 0;

		for (int i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
			char digit = candidate.charAt(i);
			int index = target.indexOf(digit);

			strikeCount += countStrike(index, i);
			ballCount += countBall(index, i);
		}

		return BallCounts.of(strikeCount, ballCount);
	}

	private boolean isAllDigitValidRange(String inputString) {
		final String regex = "[1-9]+";

		if (!inputString.matches(regex)) {
			System.out.print("각 자리는 1 ~ 9 의 숫자만 가능합니다. ");
		}

		return inputString.matches(regex);
	}

	private boolean hasDuplicatedNumber(String inputString) {
		final Set<Character> characters = new HashSet<>();

		for (char character : inputString.toCharArray()) {
			characters.add(character);
		}

		if (characters.size() != BASEBALL_NUMBER_LENGTH) {
			System.out.print("각 자리의 숫자는 중복되지 않아야합니다. ");
		}

		return characters.size() != BASEBALL_NUMBER_LENGTH;
	}

	private int countStrike(int foundedIndex, int charAt) {
		if (foundedIndex == charAt) {
			return 1;
		}

		return 0;
	}

	private int countBall(int foundedIndex, int charAt) {
		if (foundedIndex != -1 && foundedIndex != charAt) {
			return 1;
		}

		return 0;
	}
}
