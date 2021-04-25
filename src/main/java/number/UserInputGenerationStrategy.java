package number;

import ui.InputManager;
import ui.OutputManager;
import ui.PrintOutputManager;
import ui.ScannerInputManager;

public class UserInputGenerationStrategy implements NumbersGenerationStrategy {

	private final InputManager inputManager = ScannerInputManager.getInstance();
	private final OutputManager outputManager = PrintOutputManager.getInstance();

	private static NumbersGenerationStrategy numbersGenerationStrategy = new UserInputGenerationStrategy();

	private UserInputGenerationStrategy() {
	}

	public static NumbersGenerationStrategy getInstance() {
		return numbersGenerationStrategy;
	}

	@Override
	public BaseballNumbers generate() {
		BaseballNumbers result = null;

		try {
			result = baseballNumbersFactory.baseballNumbers(inputManager.nextInt());
		} catch (IllegalArgumentException e) {			
			outputManager.print(e.getMessage() + " 재입력 : ");
			return generate();
		}

		return result;
	}

}
