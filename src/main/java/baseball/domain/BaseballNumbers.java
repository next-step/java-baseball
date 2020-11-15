package baseball.domain;

import static baseball.domain.BaseballStatus.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.domain.exception.DuplicateNumberInputException;
import baseball.domain.exception.NumbersLengthException;

public class BaseballNumbers {

	private static final int NUMBERS_SIZE = 3;
	private static final int START_INDEX = 0;
	private static final int NOT_FOUND_INDEX = -1;
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

	public List<BaseballStatus> calculateScore(BaseballNumbers targetNumbers) {
		List<BaseballStatus> statuses = new ArrayList<>();
		final List<BaseballNumber> targetNums = targetNumbers.numbers;

		for (int i = START_INDEX; i < targetNums.size(); i++) {
			final int index = this.numbers.indexOf(targetNums.get(i));
			statuses.add(findStatus(index, i));
		}

		return statuses;
	}

	private BaseballStatus findStatus(int src, int target) {
		if (src == target) {
			return STRIKE;
		}
		if (src == NOT_FOUND_INDEX) {
			return NOTHING;
		}
		return BALL;
	}
}
