package baseball.util;

import java.util.LinkedHashSet;
import java.util.Set;

public class GetPlayerNumber {

	public static Set<Integer> getPlayerNumber(String input) {
		String[] splitInput = splitString(input);

		Set<Integer> playerNumber = convertFromStringToHashSet(splitInput);

		if (playerNumber != null && (!inputValidationSize(splitInput.length) || !inputValidationSize(
			playerNumber.size()))) {
			return null;
		}

		return playerNumber;
	}

	public static String[] splitString(String input) {
		return input.split("");
	}

	public static Boolean inputValidationSize(Integer inputSize) {

		if (inputSize != 3) {
			return false;
		}

		return true;
	}

	public static Set<Integer> convertFromStringToHashSet(String[] input) {
		Set<Integer> saveNumber;

		try {
			saveNumber = addLinkedHashSet(input);
		} catch (NumberFormatException e) {
			return null;
		}

		return saveNumber;
	}

	public static Set<Integer> addLinkedHashSet(String[] input) {
		Set<Integer> set = new LinkedHashSet<>();

		for (int i = 0; i < input.length; i++) {
			set.add(convertFromStringToInteger(input[i]));
		}

		return set;
	}

	public static Integer convertFromStringToInteger(String input) {
		return Integer.parseInt(input);
	}

}
