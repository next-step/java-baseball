package baseball.domain;

import java.util.List;

import baseball.util.NumberGenerator;

public class Computer implements Questioner {

	private static final int NUMBER_SIZE = 3;
	private final BaseballNumbers baseballNumbers;

	private Computer(NumberGenerator numberGenerator) {
		this.baseballNumbers = BaseballNumbers.of(numberGenerator.generate(NUMBER_SIZE));
	}

	public static Computer of(NumberGenerator generator) {
		return new Computer(generator);
	}


	@Override
	public int numberSize() {
		return baseballNumbers.size();
	}

	@Override
	public List<BaseballStatus> checkScore(BaseballNumbers targetNumbers) {
		return baseballNumbers.calculateScore(targetNumbers);
	}
}
