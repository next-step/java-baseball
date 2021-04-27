package baseball.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {

	public static final int NUMBER_LENGTH = 3;

	private int[] target;

	public void start() {
		target = generateRandomNumbers();
	}

	public int[] getTarget() {
		return target.clone();
	}

	private int[] generateRandomNumbers() {
		Integer[] allNumbers = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		List<Integer> pocket = Arrays.asList(allNumbers);
		Collections.shuffle(pocket);

		int[] numbers = new int[NUMBER_LENGTH];
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			numbers[i] = pocket.get(i);
		}
		return numbers;
	}
}
