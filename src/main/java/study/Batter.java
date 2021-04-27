package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Batter {
	public List<Integer> swingBat(String numbersStr) {
		validateInput(numbersStr);

		List<Integer> numbers = new ArrayList<>(3);
		for (int i = 0; i < numbersStr.length(); i++) {
			int num = getNumber(numbersStr, i);

			if (num < 1 || 9 < num) {
				throw new IllegalArgumentException("invalid number: " + num);
			}

			addNumber(numbers, num);
		}

		validateResult(numbers);

		return Collections.unmodifiableList(numbers);
	}

	private void validateInput(String numbersStr) {
		if (StringUtils.isBlank(numbersStr) || StringUtils.length(numbersStr) != 3) {
			throw new IllegalArgumentException("input length must be 3 characters");
		}
	}

	private void validateResult(List<Integer> numbers) {
		if (numbers.size() != 3) {
			throw new IllegalArgumentException("detected duplicate number");
		}
	}

	private int getNumber(String numbersStr, int i) {
		String numStr = numbersStr.substring(i, i + 1);
		return Integer.parseInt(numStr);
	}

	private void addNumber(List<Integer> numbers, int number) {
		if (numbers.contains(number)) {
			return;
		}
		numbers.add(number);
	}
}
