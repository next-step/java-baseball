package number;

public interface NumbersGenerationStrategy {
	
	BaseballNumbersFactory baseballNumbersFactory = BaseballNumbersFactory.getInstance();
	
	BaseballNumbers generate();
}
