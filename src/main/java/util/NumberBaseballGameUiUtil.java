package util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberBaseballGameUiUtil {
	static public int getUserCommand(Scanner sc) {
		int input = 0;

		do {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			input = sc.nextInt();
		} while (!NumberBaseballGameCommand.validateCommand(input));

		return input;
	}
	
	static public int[] getUserInputNumber(Scanner sc) {
		String input;

		do {
			System.out.print("숫자를 입력해주세요 : ");
			input = sc.next();
		} while (!isValidInput(input));

		return NumberBaseballGameTypeConverter.convertStringToIntArray(input);
	}

	static public boolean isValidInput(String input) {
		if (input == null || input.length() != 3) {
			return false;
		}

		if (containsZero(input) || !isConvertibleToNumber(input)) {
			return false;
		}

		return true;
	}

	// isConvertibleToNumber checks if user input is convertible to number
	static public boolean isConvertibleToNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException nfe) {
			return false;
		}

		return true;
	}

	static public void printGuessResult(int strikeCount, int ballCount) {
		if (strikeCount == 0 && ballCount == 0) {
			System.out.println("낫싱");
			return;
		}

		printStrikeCount(strikeCount, ballCount);

		printBallCount(ballCount);

		System.out.println();
	}

	static private void printStrikeCount(int strikeCount, int ballCount) {
		if (strikeCount == 0) {
			return;
		}

		System.out.print(strikeCount + " 스트라이크");

		if (ballCount != 0) {
			System.out.print(" ");
		}
	}

	static private void printBallCount(int ballCount) {
		if (ballCount == 0) {
			return;
		}

		System.out.print(ballCount + " 볼");
	}

	static boolean containsZero(String input) {
		Set<Character> inputNumbers = new HashSet<>();

		for (char ch : input.toCharArray()) {
			inputNumbers.add(ch);
		}

		return inputNumbers.contains('0');
	}
}
