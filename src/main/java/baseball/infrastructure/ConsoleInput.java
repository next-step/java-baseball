package baseball.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import baseball.infrastructure.exception.InvalidNumberInputException;
import baseball.infrastructure.exception.InvalidSizeInputException;

public class ConsoleInput {

	private static final int BASEBALL_NUMBER_SIZE = 3;
	private static final int START_RANGE = 0;
	private static final int END_RANGE = 9;
	private static final Scanner CONSOLE = new Scanner(System.in);

	public static List<Integer> inputStringToIntegerList() {
		final String input = CONSOLE.nextLine();
		if (input.length() != BASEBALL_NUMBER_SIZE) {
			throw new InvalidSizeInputException(BASEBALL_NUMBER_SIZE);
		}

		return stringToIntegerList(input);
	}

	private static List<Integer> stringToIntegerList(String input) {
		List<Integer> numbers = new ArrayList<>();
		for (char c : input.toCharArray()) {
			numbers.add(characterToInt(c));
		}
		return numbers;
	}

	private static int characterToInt(char c) {
		int input = c - '0';
		if (input < START_RANGE || input > END_RANGE) {
			throw new InvalidNumberInputException(c);
		}
		return input;
	}

	public static int inputStringToInt() {
		return Integer.parseInt(CONSOLE.nextLine());
	}
}
