package baseball.game;

import static baseball.game.Game.*;

public class Balls {

	private int[] numbers = new int[BALL_COUNT];

	public Balls(String ballNumbers) {
		try {
			validateLength(ballNumbers);
			setNumbers(ballNumbers);
		} catch (IllegalArgumentException e) {
			throw new InvalidBallNumbersException(ballNumbers);
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

	private void validateLength(String ballNumbers) {
		if (ballNumbers == null || ballNumbers.length() != BALL_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	private void setNumbers(String ballNumbers) {
		boolean[] availableBallNumbers = setAvailableBallNumbers();
		for (int i = 0; i < BALL_COUNT; i++) {
			this.numbers[i] = parseToNumericValue(ballNumbers.charAt(i));
			if (!availableBallNumbers[this.numbers[i]]) {
				throw new IllegalArgumentException();
			}
			availableBallNumbers[this.numbers[i]] = false;
		}
	}

	private boolean[] setAvailableBallNumbers() {
		boolean[] availableNumbers = new boolean[10];
		for (int i : ALLOWED_BALL_NUMBERS) {
			availableNumbers[i] = true;
		}
		return availableNumbers;
	}

	private int parseToNumericValue(char ballNumber) {
		if (ballNumber < '0' || ballNumber > '9') {
			throw new IllegalArgumentException();
		}
		return ballNumber - '0';
	}
}
