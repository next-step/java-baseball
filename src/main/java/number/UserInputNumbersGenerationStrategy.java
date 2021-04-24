package number;

import ui.InputManager;
import ui.ScannerInputManager;

public class UserInputNumbersGenerationStrategy implements NumbersGenerationStrategy {

	private final InputManager inputManager = ScannerInputManager.getInstance();

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
