package com.pointware.game.input;

import java.util.Scanner;
import java.util.function.Predicate;

public class InputManager {

	private Scanner scanner = new Scanner(System.in);

	protected InputManager() {
	}

	public int getInput() {
		int input;
		do {
			System.out.print(getMessage());
			String inputLine = scanner.nextLine();
			input = parse(inputLine);
		} while (!defaultValidate(input) && !getValidator().test(input));
		return input;
	}

	private boolean defaultValidate(int parsed) {
		return parsed != 0;
	}

	private int parse(String inputLine) {
		try {
			return Integer.parseInt(inputLine);
		} catch (NumberFormatException ignored) {
		}
		return 0;
	}

	protected String getMessage() {
		return "";
	}

	protected Predicate<Integer> getValidator() {
		return input -> true;
	}
}
