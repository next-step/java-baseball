package io.github.sejoung.baseball.validator;

import static io.github.sejoung.baseball.constants.GameMessage.*;

import java.util.HashSet;
import java.util.Set;

public class BaseBallValidator {

	private final String input;

	private final boolean isEnd;

	public BaseBallValidator(String input, boolean isEnd) {
		this.input = input;
		this.isEnd = isEnd;
	}

	public void valid() {
		integerCheck();
		lengthCheck(isEnd ? 1 : 3);
		rangeAndDuplicateCheck();
	}

	private void integerCheck() {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력 가능합니다.");
		}
	}

	private void lengthCheck(int length) {
		if (input.length() != length) {
			throw new IllegalArgumentException(String.format("%d 자리수만 입력 가능합니다.", length));
		}
	}

	private void rangeAndDuplicateCheck() {
		char[] numbers = input.toCharArray();
		Set<Integer> duplicateCheckSet = new HashSet<>();
		for (char number : numbers) {
			int temp = Character.getNumericValue(number);
			rangeCheck(temp);
			duplicateCheckSet.add(temp);
		}

		if (!isEnd) {
			duplicateCheck(duplicateCheckSet);
		}
	}

	private void duplicateCheck(Set<Integer> checkSet) {
		if (checkSet.size() < 3) {
			throw new IllegalArgumentException("중복된 숫자가 있습니다.");
		}
	}

	private void rangeCheck(int number) {
		if (isEnd) {
			rangeCheckIsEnd(number);
		}
		if (number == 0) {
			throw new IllegalArgumentException("0은 입력되지 않습니다.");
		}
	}

	private void rangeCheckIsEnd(int number) {
		if (number != 1 && number != 2) {
			throw new IllegalArgumentException(RESTART.getMessage());
		}
	}

}
