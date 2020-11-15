package baseball.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput {

	private static final Scanner CONSOLE = new Scanner(System.in);

	public static List<Integer> inputStringToIntegerList() {
		final String input = CONSOLE.nextLine();
		List<Integer> numbers = new ArrayList<>();
		for (char c : input.toCharArray()) {
			numbers.add(c - '0');
		}

		return numbers;
	}

	public static int inputStringToInt() {
		return Integer.parseInt(CONSOLE.nextLine());
	}
}
