package baseball.domain;

import java.util.HashSet;
import java.util.Set;

import baseball.constant.MessageContainer;
import baseball.exception.InvalidNumberException;

public class GuessBaseballNumber extends BaseballNumber {
	public GuessBaseballNumber(Integer... numbers) {
		super(numbers);
		validateBaseballNumber();
	}

	public GuessBaseballNumber(String input, int ballCount) {
		super(input, ballCount);
		validateBaseballNumber();
	}

	public void validateBaseballNumber() {
		validateDuplicate();
		validateNumberRange();
	}

	public void validateDuplicate() {
		Set<Integer> numberSet = new HashSet<>(getNumbers());

		if (getBallCount() != numberSet.size()) {
			throw new InvalidNumberException(MessageContainer.INPUT_DUPLICATE_ERROR_MESSAGE);
		}
	}

	public void validateNumberRange() {
		for (int number : getNumbers()) {
			isValidRange(number);
		}
	}

	public boolean isValidRange(int number) {
		if (number <= BALL_MAX_VALUE && number >= BALL_MIN_VALUE) {
			return true;
		}
		throw new InvalidNumberException(String.format(MessageContainer.INPUT_RANGE_ERROR_MESSAGE,
			BALL_MIN_VALUE, BALL_MAX_VALUE));
	}

}
