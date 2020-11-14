package baseball.domain;

import baseball.util.NumberGenerator;

public class Computer implements Questioner {

	private static final int NUMBER_SIZE = 3;
	private BaseballNumbers baseballNumbers;

	@Override
	public void generateNumbers(NumberGenerator generator) {
		this.baseballNumbers = BaseballNumbers.of(generator.generate(NUMBER_SIZE));
	}

	@Override
	public int numberSize() {
		return baseballNumbers.size();
	}
}
