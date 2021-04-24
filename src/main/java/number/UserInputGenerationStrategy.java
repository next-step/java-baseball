package number;

import ui.InputManager;
import ui.ScannerInputManager;

public class UserInputGenerationStrategy implements NumbersGenerationStrategy {

	private static NumbersGenerationStrategy numbersGenerationStrategy = new UserInputGenerationStrategy(
			ScannerInputManager.getInstance());

	private UserInputGenerationStrategy(InputManager inputManager) {
		this.inputManager = inputManager;
	}

	public static NumbersGenerationStrategy getInstance() {
		return numbersGenerationStrategy;
	}

	private final InputManager inputManager;

	@Override
	public BaseballNumbers generate() {
		BaseballNumbers result = null;

		try {
			result = baseballNumbersFactory.baseballNumbers(inputManager.nextInt());
		} catch (IllegalArgumentException e) {
			return generate();
		}

		return result;
	}

}
