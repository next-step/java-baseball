package baseball.util;

import java.util.List;

public class ParameterNumberGenerator implements NumberGenerator {
	private final List<Integer> numbers;

	public ParameterNumberGenerator(List<Integer> numbers) {
		this.numbers = numbers;
	}

	@Override
	public List<Integer> generate(int size) {
		return numbers;
	}
}
