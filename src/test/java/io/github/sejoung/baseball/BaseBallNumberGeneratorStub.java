package io.github.sejoung.baseball;

import java.util.List;

public class BaseBallNumberGeneratorStub implements BaseBallNumberGenerator {

	private final List<Integer> numbers;

	public BaseBallNumberGeneratorStub(List<Integer> numbers) {
		this.numbers = numbers;
	}

	@Override
	public List<Integer> generateBaseBallNumbers() {
		return numbers;
	}
}
