package io.github.sejoung.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomBaseBallNumberGenerator implements BaseBallNumberGenerator {

	@Override
	public List<Integer> generateBaseBallNumbers() {
		int MAX_SIZE = 3;
		List<Integer> numbers = new ArrayList<>(MAX_SIZE);
		while (numbers.size() < MAX_SIZE) {
			addNumber(numbers);
		}
		return numbers;
	}

	private void addNumber(List<Integer> numbers) {
		int MIN_NUMBER = 1;
		int MAX_NUMBER = 9;
		int random = ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER);
		if (!numbers.contains(random)) {
			numbers.add(random);
		}
	}

}
