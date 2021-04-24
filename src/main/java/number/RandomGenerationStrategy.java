package number;

public class RandomGenerationStrategy implements NumbersGenerationStrategy {

	private static NumbersGenerationStrategy numbersGenerationStrategy = new RandomGenerationStrategy();

	private RandomGenerationStrategy() {
	}

	public static NumbersGenerationStrategy getInstance() {
		return numbersGenerationStrategy;
	}

	@Override
	public BaseballNumbers generate() {
		BaseballNumbers result = null;

		try {
			result = baseballNumbersFactory.baseballNumbers((int) (Math.random() * 1000));
		} catch (IllegalArgumentException e) {
			return generate();
		}

		return result;
	}

}
