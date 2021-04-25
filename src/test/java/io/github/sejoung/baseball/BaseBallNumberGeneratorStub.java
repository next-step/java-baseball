package io.github.sejoung.baseball;

import java.util.Arrays;
import java.util.List;

public class BaseBallNumberGeneratorStub implements BaseBallNumberGenerator {

	private final List<List<Integer>> numbers;
	private int index;

	public BaseBallNumberGeneratorStub(List<Integer>... numbers) {
		this.numbers = Arrays.asList(numbers);
		index = 0;
	}

	@Override
	public List<Integer> generateBaseBallNumbers() {
		List<Integer> number = numbers.get(index);
		index = (index + 1) % numbers.size();

		return number;
	}
}
