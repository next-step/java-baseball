package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Batter {
	public List<Integer> swingBat(String numbersStr) {
		validateInput(numbersStr);
		List<Integer> numbers = parse(numbersStr);
		validateResult(numbers);
		return numbers;
	}

	private List<Integer> parse(String numbersStr) {
		List<Integer> numbers = new ArrayList<>(3);

		for (int i = 0; i < numbersStr.length(); i++) {
			int num = getNumber(numbersStr, i);
			validateNumberRange(num);
			addNumberIfNotContains(numbers, num);
		}
		return Collections.unmodifiableList(numbers);
	}

	private int getNumber(String numbersStr, int index) {
		String numStr = numbersStr.substring(index, index + 1);
		return Integer.parseInt(numStr);
	}

	private void addNumberIfNotContains(List<Integer> numbers, int number) {
		if (numbers.contains(number)) {
			return;
		}
		numbers.add(number);
	}

	private void validateInput(String numbersStr) {
		if (StringUtils.length(numbersStr) != 3 || !StringUtils.isNumeric(numbersStr)) {
			throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
		}
	}

	private void validateNumberRange(int num) {
		if (isNumBetween1And9(num)) {
			throw new IllegalArgumentException("1 ~ 9 범위의 숫자를 입력해주세요.");
		}
	}

	private boolean isNumBetween1And9(int num) {
		return num < 1 || 9 < num;
	}

	private void validateResult(List<Integer> numbers) {
		if (numbers.size() != 3) {
			throw new IllegalArgumentException("각 자리마다 서로 다른 숫자를 입력하세요.");
		}
	}
}
