package baseball.core;

import java.util.List;
import java.util.LinkedList;

public class GameNumber {
	private final int DIGITS_MAX = 9;
	private final int DIGITS_MIN = 1;
	private List<Integer> numbers;

	public GameNumber() {
		numbers = new LinkedList<>();
	}

	public int getRandom(int digits) {
		if (digits < DIGITS_MIN || digits > DIGITS_MAX) {
			throw new IllegalArgumentException(String.format("파라미터의 값은 %d~%d까지 지원합니다.", DIGITS_MIN, DIGITS_MAX));
		}
		registNumbers();

		int result = 0;
		for (int i = 0; i < digits; i++) {
			result += getRandom() * Math.pow(10, i);
		}

		return result;
	}

	private void registNumbers() {
		numbers.clear();

		for (int i = 0; i < DIGITS_MAX; i++) {
			numbers.add(i + 1);
		}
	}

	private int getRandom() {
		int randomIndex = (int)(Math.random() * numbers.size());

		return numbers.remove(randomIndex);
	}
}
