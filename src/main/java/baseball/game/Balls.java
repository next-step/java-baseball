package baseball.game;

import static baseball.game.Game.*;

public class Balls {

	private int[] numbers = new int[BALL_COUNT];

	public Balls(String numbers) {
		try {
			validateLength(numbers);
			setNumbers(numbers);
		} catch (IllegalArgumentException e) {
			throw new InvalidBallNumbersException(numbers);
		}
	}

	public int[] getNumbers() {
		return this.numbers;
	}

	public int getNumber(int position) {
		if (position >= BALL_COUNT) {
			throw new IllegalArgumentException();
		}
		return this.numbers[position];
	}

	private void validateLength(String numbers) {
		if (numbers == null || numbers.length() != BALL_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	private void setNumbers(String numbers) {
		boolean[] availableNumbers = setAvailableNumbers();
		for (int i = 0; i < BALL_COUNT; i++) {
			this.numbers[i] = parseToNumericValue(numbers.charAt(i));
			if (!availableNumbers[this.numbers[i]]) {
				throw new IllegalArgumentException();
			}
			availableNumbers[this.numbers[i]] = false;
		}
	}

	private boolean[] setAvailableNumbers() {
		boolean[] availableNumbers = new boolean[10];
		for (int i : ALLOWED_BALL_NUMBERS) {
			availableNumbers[i] = true;
		}
		return availableNumbers;
	}

	private int parseToNumericValue(char character) {
		if (character < '0' || character > '9') {
			throw new IllegalArgumentException();
		}
		return character - '0';
	}
}
