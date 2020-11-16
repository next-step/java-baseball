package baseball.util;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import baseball.service.BaseballGameService;

public class UserInput {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final UserOutput output = new UserOutput();

	private Integer userResultInput;

	public Integer userInputNumber() {

		do {
			output.printToBeContinued();
		} while (userCorrectInputCheck());

		return this.userResultInput;
	}

	private boolean userCorrectInputCheck() {

		String inputNumber = SCANNER.nextLine();
		if (!userInputNumberEvent(inputNumber)) {
			validRestartNumber
		}
		return !
	}

	private boolean isNumber(String inputNumber) {

		boolean result = true;

		try {
			Integer.parseInt(inputNumber);
		} catch (InputMismatchException | NumberFormatException exception) {
			output.printInputError();
			result = false;
		}

		return result;
	}

	private boolean userInputNumberEvent(String inputNumber) {

		return isNumber(inputNumber);
	}

	public boolean validRestartNumber(String inputRestartNumber) {

		Integer validNumber = Integer.parseInt(inputRestartNumber);

		if (validNumber.equals(BaseballGameService.GAME_RESTART) || validNumber.equals(BaseballGameService.GAME_END)) {

			this.userResultInput = validNumber;
			return true;
		}

		output.printInputError();
		return false;
	}

	public void userGameNumber() {

		SCANNER.nextLine()
	}
}
