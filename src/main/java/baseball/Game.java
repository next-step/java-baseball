package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
	public static int MAX_GAME_NUMBER_LENGTH = 3;
	private static String INPUT_DELIMITER = "";
	private static String INVALID_INPUT_ERROR_MESSAGE = "Invalid Input";
	private GameNumbers rightAnswer;

	public Game(GameNumberGenerator gameNumberGenerator) {
		rightAnswer = gameNumberGenerator.generate(MAX_GAME_NUMBER_LENGTH);
	}

	public GameNumbers getRightAnswer() {
		return rightAnswer;
	}

	public GameNumbers convertInputToGameNumbers(String input) {
		String[] split = input.split(INPUT_DELIMITER);
		assertValidInputLength(split.length);

		List<Integer> numbers = new ArrayList<>();
		for (String value : split) {
			numbers.add(convertInputToInteger(value));
		}

		return new GameNumbers(numbers);
	}

	private void assertValidInputLength(int inputLength) {
		if (inputLength != MAX_GAME_NUMBER_LENGTH) {
			throw new InvalidGameInputException(INVALID_INPUT_ERROR_MESSAGE);
		}
	}

	private Integer convertInputToInteger(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new InvalidGameInputException(INVALID_INPUT_ERROR_MESSAGE);
		}
	}
}
