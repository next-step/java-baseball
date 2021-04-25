package baseball;

import java.util.Arrays;

public class Player {

	private int[] numbers;

	public Player() {
	}

	public Player(int[] numbers) {
		this.numbers = numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public int[] getNumbers() {
		return numbers;
	}

	@Override
	public String toString() {
		return Arrays.toString(numbers);
	}
}
