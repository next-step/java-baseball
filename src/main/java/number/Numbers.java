package number;

import static number.Hint.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Numbers {
	public static final int LENGTH = 3;
	private static final int FIRST_POSITION = 0;
	private static final int NOT_MATCH_POSITION = -1;
	private final List<Number> numbers;

	private Numbers(List<Number> numbers) {
		checkValidation(numbers);
		this.numbers = Collections.unmodifiableList(numbers);
	}

	private void checkValidation(List<Number> numbers) {
		checkLengthOfNumbers(numbers);
		checkDuplicationOfNumbers(numbers);
	}

	private void checkLengthOfNumbers(List<Number> numbers) {
		if (numbers.size() != LENGTH) {
			throw IllegalNumberException.ILLEGAL_LENGTH_OF_NUMBERS;
		}
	}

	private void checkDuplicationOfNumbers(List<Number> numbers) {
		Set<Number> numberSet = new HashSet<>(numbers);
		if (numberSet.size() != LENGTH) {
			throw IllegalNumberException.DUPLICATION_OF_NUMBERS;
		}
	}

	public static Numbers of(String inputString) {
		List<Number> inputNumbers = new ArrayList<>();
		for (char digit : inputString.toCharArray()) {
			inputNumbers.add(Number.of(digit));
		}
		return new Numbers(inputNumbers);
	}

	public static Numbers of(Set<Integer> inputSet) {
		List<Number> inputNumbers = new ArrayList<>();
		for (Integer number : inputSet) {
			inputNumbers.add(Number.of(number));
		}
		return new Numbers(inputNumbers);
	}

	public HintsCount compareNumbers(Numbers otherNumbers) {
		List<Hint> hints = new ArrayList<>();
		for (int position = FIRST_POSITION; position < numbers.size(); position++) {
			Number number = numbers.get(position);
			Hint hint = otherNumbers.comparePositionOfNumber(number, position);
			hints.add(hint);
		}
		return HintsCount.of(hints);
	}

	private Hint comparePositionOfNumber(Number otherNumber, int otherPosition) {
		final int position = numbers.indexOf(otherNumber);
		if (position == NOT_MATCH_POSITION) {
			return NOTHING;
		}
		if (position == otherPosition) {
			return STRIKE;
		}
		return BALL;
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
