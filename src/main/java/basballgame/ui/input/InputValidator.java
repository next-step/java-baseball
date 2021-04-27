package basballgame.ui.input;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sun.tools.javac.util.StringUtils;

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
			Integer.parseInt(inputString);
		} catch (NumberFormatException e) {
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

	private static String trim(String inputString) {
		if(inputString == null || inputString.length() == 0)
			throw new NumberFormatValidationException();

		return inputString.trim();
	}

	public static void validateBaseballNumberInput(String inputString) {
		String trimInputString = trim(inputString);
		validateNumberFormat(trimInputString);
		validateNumRange(trimInputString);
		validateMultipleUseNumber(trimInputString);
	}

	public static void validateGameRestartInputNumber(String inputString) {
		String trimInputString = trim(inputString);
		validateNumberFormat(trimInputString);
		int inputNumber = Integer.parseInt(trimInputString);

		if(inputNumber != GAME_RESTART && inputNumber != GAME_EXIT)
			throw new GameRestartInputValidationException();
	}
}
