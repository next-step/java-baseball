package com.baseball.woowahan;

import java.io.IOException;

public class UserInput {
	private UserInputGenerator userInputGenerator;
	private UserInputValidator userInputValidator;

	public UserInput(UserInputGenerator userInputGenerator, UserInputValidator userInputValidator) {
		this.userInputGenerator = userInputGenerator;
		this.userInputValidator = userInputValidator;
	}

	public String returnInputNumber() throws IOException {
		boolean validation = false;
		String input = "";
		while (!validation) {
			input = userInputGenerator.enterInput();
			validation = userInputValidator.isValid(input);
			printLogWhenInvalid(validation);
		}
		return input;
	}

	private void printLogWhenInvalid(boolean validation) {
		if (!validation) {
			System.out.println(Message.INVALID.getMessage());
		}
	}
}
