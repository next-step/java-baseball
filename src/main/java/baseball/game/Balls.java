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
		boolean[] canUse = new boolean[10];
		setCanUse(canUse);
		for (int i = 0; i < BALL_COUNT; i++) {
			this.numbers[i] = parseToNumericValue(numbers.charAt(i));
			if (!canUse[this.numbers[i]]) {
				throw new IllegalArgumentException();
			}
			canUse[this.numbers[i]] = false;
		}
	}

	private void setCanUse(boolean[] canUse) {
		for (int i : ALLOWED_BALL_NUMBERS) {
			canUse[i] = true;
		}
	}

	private int parseToNumericValue(char c) {
		if (c < '0' || c > '9') {
			throw new IllegalArgumentException();
		}
		return c - '0';
	}
}
