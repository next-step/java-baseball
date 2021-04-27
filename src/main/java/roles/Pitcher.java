package roles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

import constants.Messages;
import constants.PlayRules;
import exception.PitcherInputException;

public class Pitcher {
	private Scanner scanner = new Scanner(System.in);

	public List<Integer> inputGameNumbers() {
		String inputText = null;
		do {
			inputText = scanner.nextLine();
		} while (!validInputNumber(inputText));
		return convertStringToIntegerList(inputText);
	}

	private List<Integer> convertStringToIntegerList(String integerText) {
		List<Integer> returnList = new ArrayList<>();
		for (String s : Arrays.asList(integerText.split(""))) {
			returnList.add(Integer.valueOf(s));
		}
		return returnList;
	}

	private boolean validInputNumber(String inputText) {
		try {
			checkLength(inputText);
			checkNumberType(inputText);
			checkDuplicateNumbers(inputText);
		} catch (PitcherInputException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	private void checkLength(String inputText) throws PitcherInputException {
		if (inputText.length() != PlayRules.BALL_LENGTH.value()) {
			throw new PitcherInputException(Messages.CHECK_INPUT_NUMBER.value());
		}
	}

	private void checkNumberType(String inputText) throws PitcherInputException {
		if (!Pattern.matches("^[1-9]*$", inputText)) {
			throw new PitcherInputException(Messages.CHECK_INPUT_NUMBER.value());
		}
	}

	private void checkDuplicateNumbers(String inputText) throws PitcherInputException {
		Set<String> inputSet = new HashSet<>();
		inputSet.addAll(Arrays.asList(inputText.split("")));
		if (inputSet.size() != PlayRules.BALL_LENGTH.value()) {
			throw new PitcherInputException(Messages.CHECK_INPUT_NUMBER.value());
		}
	}
}
