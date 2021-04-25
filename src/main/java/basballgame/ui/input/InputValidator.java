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
		if (inputNumber < 111 || inputNumber > 999)
			throw new NumberRangeValidationException();
	}

	private static void validateMultipleUseNumber(String inputString) {
		List<Character> inputList = Arrays.asList(inputString.charAt(0), inputString.charAt(1), inputString.charAt(2));
		Set<Character> inputSet = new HashSet<>(inputList);
		if (inputSet.size() < 3)
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

		if(inputNumber != 1 && inputNumber != 2)
			throw new GameRestartInputValidationException();
	}
}
