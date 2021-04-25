package basballgame.ui.input;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import basballgame.exception.GameRestartInputValidationException;
import basballgame.exception.MultipleUseNumberValidationException;
import basballgame.exception.NumberFormatValidationException;
import basballgame.exception.NumberRangeValidationException;

public class InputValidator {

	private static final int BASEBALL_INPUT_NUM_MIN = 111;
	private static final int BASEBALL_INPUT_NUM_MAX = 999;
	private static final int GAME_RESTART = 1;
	private static final int GAME_EXIT = 2;
	private static final int REQUIRED_INPUT_NUMBER_COUNT = 3;

	private static void validateNumberFormat(String inputString) {
		try {
			String trimInputString = inputString.trim();
			Integer.parseInt(trimInputString);
		} catch (NumberFormatException | NullPointerException e) {
			throw new NumberFormatValidationException();
		}
	}

	private static void validateNumRange(String inputString ) {
		int inputNumber = Integer.parseInt(inputString);
		if (inputNumber < BASEBALL_INPUT_NUM_MIN || inputNumber > BASEBALL_INPUT_NUM_MAX)
			throw new NumberRangeValidationException();
	}

	private static void validateMultipleUseNumber(String inputString) {
		List<Character> inputList = Arrays.asList(inputString.charAt(0), inputString.charAt(1), inputString.charAt(2));
		Set<Character> inputSet = new HashSet<>(inputList);
		if (inputSet.size() < REQUIRED_INPUT_NUMBER_COUNT)
			throw new MultipleUseNumberValidationException();
	}

	public static void validateBaseballNumberInput(String inputString) {
		validateNumberFormat(inputString);
		validateNumRange(inputString);
		validateMultipleUseNumber(inputString);
	}

	public static void validateGameRestartInputNumber(String inputString) {
		validateNumberFormat(inputString);
		int inputNumber = Integer.parseInt(inputString);

		if(inputNumber != GAME_RESTART && inputNumber != GAME_EXIT)
			throw new GameRestartInputValidationException();
	}
}
