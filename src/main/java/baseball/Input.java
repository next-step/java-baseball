package baseball;

import java.util.Scanner;

import baseball.exception.BadInputException;

class Input {
	private int numberLength;
	private Scanner scanner;

	Input(int numberLength) {
		this.numberLength = numberLength;
		this.scanner = new Scanner(System.in);
	}

	int getGuessInput() {
		int input = getIntInput();
		int length = (int)(Math.log10(input) + 1);

		if (length != numberLength) {
			throw new BadInputException();
		}

		return input;
	}

	int getProceedInput() {
		int input = getIntInput();

		if (input != 1 && input != 2) {
			throw new BadInputException();
		}

		return input;
	}

	private int getIntInput() {
		try {
			return scanner.nextInt();
		} catch (Exception e) {
			throw new BadInputException();
		}
	}
}
