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

	public static void validateNumberFormat(String inputString) {
		try {
			Integer.parseInt(inputString);
		} catch (NumberFormatException e) {
			throw new NumberFormatValidationException();
		}
	}

	public static void validateNumRange(String inputString ) {
		int inputNumber = Integer.parseInt(inputString);
		if (inputNumber < 123 || inputNumber > 987)
			throw new NumberRangeValidationException();
	}

	public static void validateMultipleUseNumber(String inputString) {
		List<Character> inputList = Arrays.asList(
			inputString.charAt(0)
			, inputString.charAt(1)
			, inputString.charAt(2));
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
