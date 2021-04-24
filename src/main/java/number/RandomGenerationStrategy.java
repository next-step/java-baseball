package number;

public class RandomGenerationStrategy implements NumbersGenerationStrategy {
	
	@Override
	public BaseballNumbers generate() {		
		BaseballNumbers result = null;
		
		try {
			result = baseballNumbersFactory.baseballNumbers((int)(Math.random() * 1000));
		} catch (IllegalArgumentException e) {
			return generate();
		}
		
		return result;
	}

}
