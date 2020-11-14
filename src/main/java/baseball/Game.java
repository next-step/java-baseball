package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
	public static final int MAX_GAME_NUMBER_LENGTH = 3;
	private static final String INPUT_DELIMITER = "";
	private static final String INVALID_INPUT_ERROR_MESSAGE = "Invalid Input";
	private GameNumbers rightAnswer;
	private GameStatus status;

	public Game(GameNumberGenerator gameNumberGenerator) {
		status = GameStatus.IN_PROGRESSING;
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

	public void inputUserAnswer(String input) {
		GameNumbers userAnswer = convertInputToGameNumbers(input);
		if (userAnswer.equals(rightAnswer)) {
			status = GameStatus.END;
		}
	}

	public boolean isFinished() {
		return status == GameStatus.END;
	}
}
