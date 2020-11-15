package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.domain.exception.InvalidGameInputException;

public class GameInputConverter {
	private static final int MIN = 1;
	private static final int MAX = 9;
	private static final String INPUT_DELIMITER = "";
	private static final String INVALID_INPUT_ERROR_MESSAGE = "Invalid Input";

	public static GameNumbers convertInputToGameNumbers(String input, int length) {
		assertValidInputLength(input.length(), length);
		String[] split = input.split(INPUT_DELIMITER);

		List<Integer> numbers = convertInputToIntegerList(split);
		return new GameNumbers(numbers);
	}

	private static List<Integer> convertInputToIntegerList(String[] split) {
		List<Integer> numbers = new ArrayList<>();

		for (String value : split) {
			Integer integer = convertInputToInteger(value);
			assertDuplicateNumber(numbers, integer);
			numbers.add(integer);
		}

		return numbers;
	}

	private static Integer convertInputToInteger(String value) {
		try {
			int integerValue = Integer.parseInt(value);
			throwIfConditionIsTrue(integerValue < MIN || integerValue > MAX);
			return integerValue;
		} catch (NumberFormatException e) {
			throw new InvalidGameInputException(INVALID_INPUT_ERROR_MESSAGE);
		}
	}

	private static void assertDuplicateNumber(List<Integer> numbers, Integer value) {
		throwIfConditionIsTrue(numbers.contains(value));
	}

	private static void assertValidInputLength(int inputLength, int maxLength) {
		throwIfConditionIsTrue(inputLength != maxLength);
	}

	private static void throwIfConditionIsTrue(boolean condition) {
		if (condition) {
			throw new InvalidGameInputException(INVALID_INPUT_ERROR_MESSAGE);
		}
	}

	private GameInputConverter() {
	}
}
