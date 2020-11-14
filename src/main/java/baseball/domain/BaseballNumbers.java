package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.domain.exception.DuplicateNumberInputException;
import baseball.domain.exception.NumbersLengthException;

public class BaseballNumbers {

	private static final int NUMBERS_SIZE = 3;
	private final List<BaseballNumber> numbers = new ArrayList<>();

	private BaseballNumbers(List<Integer> numbers) {
		Set<Integer> lengthChecker = new HashSet<>(numbers);
		if (lengthChecker.size() != NUMBERS_SIZE) {
			throw new DuplicateNumberInputException();
		}

		for (Integer number : numbers) {
			this.numbers.add(BaseballNumber.valueOf(number));
		}

	}

	public static BaseballNumbers of(final List<Integer> numbers) {
		validateParameter(numbers);
		return new BaseballNumbers(numbers);
	}

	private static void validateParameter(List<Integer> numbers) {
		if (numbers.size() != NUMBERS_SIZE) {
			throw new NumbersLengthException(NUMBERS_SIZE);
		}
	}

	public int size() {
		return this.numbers.size();
	}
}
