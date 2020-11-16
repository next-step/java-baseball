package game.baseball.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBallNumber {
	public static final int NUMBERS_SIZE = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private final List<Integer> numbers;

	public BaseBallNumber(List<Integer> numbers) {
		validateNull(numbers);
		validateSize(numbers);
		validateDuplicate(numbers);
		validateRange(numbers);
		this.numbers = numbers;
	}

	private void validateNull(List<Integer> numbers) {
		if (numbers == null) {
			throw new IllegalArgumentException("숫자는 반드시 null이 아니어야 합니다.");
		}
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != NUMBERS_SIZE) {
			throw new IllegalArgumentException("숫자는 3자리의 수 이어야 합니다.");
		}
	}

	private void validateDuplicate(List<Integer> numbers) {
		Set<Integer> uniqueNumbers = new HashSet<>(numbers);
		if (uniqueNumbers.size() != numbers.size()) {
			throw new IllegalArgumentException("각 자리의 숫자들은 서로 다른 수 이어야 합니다.");
		}
	}

	private void validateRange(List<Integer> numbers) {
		for (Integer number : numbers) {
			validateRange(number);
		}
	}

	private void validateRange(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException("각 자리의 숫자들은 1부터 9까지 수 이어야 합니다.");
		}
	}

	public int get(int index) {
		return numbers.get(index);
	}

	public int getNumber() {
		int totalNumber = 0;

		for (Integer number : numbers) {
			totalNumber = totalNumber * 10 + number;
		}

		return totalNumber;
	}
}
