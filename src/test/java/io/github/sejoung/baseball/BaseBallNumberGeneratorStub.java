package io.github.sejoung.baseball;

import java.util.Arrays;
import java.util.List;

public class BaseBallNumberGeneratorStub implements BaseBallNumberGenerator {

	private final List<Integer> numbers;

	public BaseBallNumberGeneratorStub(Integer... numbers) {
		this.numbers = Arrays.asList(numbers);
	}

	@Override
	public List<Integer> generateBaseBallNumbers() {
		return numbers;
	}
}
