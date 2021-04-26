package baseballgame;

import java.util.Scanner;

public class User {

	private String userInput;

	public String setUserInputNumberArray() {
		try {
			System.out.println(PrintMessageEnum.ENTER_A_NUMBER.getMessage());
			Scanner scanner = new Scanner(System.in);
			userInput = scanner.nextLine();
			validateNumberInput(userInput);
			validateCharacterInput(userInput);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return userInput;
	}

	public void validateNumberInput(String userInput) {
		if (userInput.length() != 3) {
			throw new IllegalArgumentException("입력값은 3자리여야 합니다.");
		}
	}

	public void validateCharacterInput(String userInput) {
		if (!userInput.matches("^[0-9]*$")) {
			throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
		}
	}

}
