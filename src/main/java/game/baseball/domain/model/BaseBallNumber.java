package game.baseball.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import game.baseball.domain.shared.Message;
import game.baseball.domain.shared.NumberUtils;

public class BaseBallNumber {
	public static final int NUMBERS_SIZE = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private final List<Integer> numbers;

	public BaseBallNumber(List<Integer> numbers) {
		validateNull(numbers);
		validateSize(numbers);
		validateDuplication(numbers);
		validateRange(numbers);
		this.numbers = numbers;
	}

	private void validateNull(List<Integer> numbers) {
		if (numbers == null) {
			throw new IllegalArgumentException(Message.REQUIRE_NOT_NULL);
		}
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != NUMBERS_SIZE) {
			throw new IllegalArgumentException(Message.REQUIRE_THREE_DIGIT);
		}
	}

	private void validateDuplication(List<Integer> numbers) {
		Set<Integer> uniqueNumbers = new HashSet<>(numbers);
		if (uniqueNumbers.size() != numbers.size()) {
			throw new IllegalArgumentException(Message.REQUIRE_DIFFERENT_NUMBER);
		}
	}

	private void validateRange(List<Integer> numbers) {
		for (Integer number : numbers) {
			validateRange(number);
		}
	}

	private void validateRange(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException(Message.REQUIRE_ONE_TO_NINE);
		}
	}

	public int get(int index) {
		return this.numbers.get(index);
	}

	public int getNumber() {
		return NumberUtils.combine(this.numbers);
	}
}
