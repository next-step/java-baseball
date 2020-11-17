package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import constants.GameNumberRule;
import exception.InputValidException;

public class ValidationCheckUtil {
	public void checkLength(String inputText, String message) throws InputValidException {
		if (inputText.length() != GameNumberRule.LENGTH.getValue()) {
			throw new InputValidException(message);
		}
	}

	public void checkNumber(String inputText, String message) throws InputValidException {
		if (!Pattern.matches("^[1-9]*$", inputText)) {
			throw new InputValidException(message);
		}
	}

	public void checkDuplicateNumbers(String inputText, String message) throws InputValidException {
		Set<String> inputSet = new HashSet<>();
		inputSet.addAll(Arrays.asList(inputText.split("")));
		if (inputSet.size() != GameNumberRule.LENGTH.getValue()) {
			throw new InputValidException(message);
		}
	}
}
