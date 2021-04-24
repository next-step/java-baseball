package number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Numbers {
	private static final int LENGTH = 3;
	private static final int LOWER_BOUND = 1;
	private static final int UPPER_BOUND = 9;
	private static final int NUMBER_RADIX = 10;

	private final List<Integer> numbers;

	private Numbers(List<Integer> numbers) {
		checkValidation(numbers);
		this.numbers = Collections.unmodifiableList(numbers);
	}

	private void checkValidation(List<Integer> numbers) {
		checkLengthOfNumbers(numbers);
		checkRangeOfNumber(numbers);
		checkDuplicationOfNumbers(numbers);
	}

	private void checkLengthOfNumbers(List<Integer> numbers) {
		if (numbers.size() != LENGTH) {
			throw IllegalNumberException.ILLEGAL_LENGTH_OF_NUMBERS;
		}
	}

	private void checkDuplicationOfNumbers(List<Integer> numbers) {
		Set<Integer> numberSet = new HashSet<>(numbers);
		if (numberSet.size() != LENGTH) {
			throw IllegalNumberException.DUPLICATION_OF_NUMBERS;
		}
	}

	private void checkRangeOfNumber(List<Integer> numbers) {
		for (Integer number : numbers) {
			checkRangeOfNumber(number);
		}
	}

	private void checkRangeOfNumber(Integer numbers) {
		if (numbers < LOWER_BOUND || numbers > UPPER_BOUND) {
			throw IllegalNumberException.ILLEGAL_RANGE_OF_NUMBER;
		}
	}

	public static Numbers of(String inputString) {
		List<Integer> inputNumbers = new ArrayList<>();
		for (char c : inputString.toCharArray()) {
			inputNumbers.add(Character.digit(c, NUMBER_RADIX));
		}
		return new Numbers(inputNumbers);
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		Numbers otherNumbers = (Numbers)other;
		return Objects.equals(numbers, otherNumbers.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
