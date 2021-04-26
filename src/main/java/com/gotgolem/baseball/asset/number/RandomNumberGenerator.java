package com.gotgolem.baseball.asset.number;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

	private final Integer[] numberRange = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};

	@Override
	public int[] generateThreeNumbers() {
		return pickThreeNumbers(getRandomSortNumbers());
	}

	private List<Integer> getRandomSortNumbers() {
		final List<Integer> numbers = Arrays.asList(numberRange);
		Collections.shuffle(numbers);
		return numbers;
	}

	private int[] pickThreeNumbers(List<Integer> numbers) {
		return new int[] {numbers.get(0), numbers.get(1), numbers.get(2)};
	}

}
