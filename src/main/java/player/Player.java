package player;

import number.BaseballNumbers;
import number.NumbersGenerationStrategy;

public abstract class Player {
	private BaseballNumbers baseballNumbers;
	private NumbersGenerationStrategy numbersGenerationStrategy;

	public Player(NumbersGenerationStrategy numbersGenerationStrategy) {
		this.numbersGenerationStrategy = numbersGenerationStrategy;
	}

	public void generateNumbers() {
		this.baseballNumbers = numbersGenerationStrategy.generate();
	}

	public BaseballNumbers getNumbers() {
		return baseballNumbers;
	}
}
