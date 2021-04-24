package com.baseball.woowahan;

public class UserInput {
	public static final int GAME_LENGTH = 3;

	public String start() {
		boolean validation = false;
		String input = "";
		UserInputGenerator userInputGenerator = new UserInputGenerator();
		UserInputValidator userInputValidator = new UserInputValidator();
		while (!validation) {
			input = userInputGenerator.start();
			validation = userInputValidator.validate(input);
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
