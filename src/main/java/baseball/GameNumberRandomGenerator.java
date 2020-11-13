package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameNumberRandomGenerator implements GameNumberGenerator {
	private static final int MIN = 1;
	private static final int MAX = 9;
	private Random random = new Random();

	@Override
	public GameNumbers generate(int length) {
		List<Integer> numbers = new ArrayList<>();
		while (numbers.size() != length) {
			int randomValue = random.nextInt(MAX) + MIN;
			addIfNotContain(numbers, randomValue);
		}
		return new GameNumbers(numbers);
	}

	private void addIfNotContain(List<Integer> numbers, int randomValue) {
		if (!numbers.contains(randomValue)) {
			numbers.add(randomValue);
		}
	}
}
