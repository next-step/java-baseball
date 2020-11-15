package UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

	public static List<Integer> inputBaseballNumbers() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		return inputToIntegers(input);
	}

	private static List<Integer> inputToIntegers(String input) {
		List<Integer> integers = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			integers.add(Character.getNumericValue(input.charAt(i)));
		}
		return integers;
	}
}
