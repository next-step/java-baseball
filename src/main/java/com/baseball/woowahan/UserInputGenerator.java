package com.baseball.woowahan;

import java.io.BufferedReader;
import java.io.IOException;

public class UserInputGenerator {
	private BufferedReader bufferedReader;
	private UserInputValidator userInputValidator;

	public UserInputGenerator(BufferedReader bufferedReader, UserInputValidator userInputValidator) {
		this.bufferedReader = bufferedReader;
		this.userInputValidator = userInputValidator;
	}

	public String returnInputNumber() throws IOException {
		boolean validation = false;
		String input = "";
		while (!validation) {
			input = enterInput();
			validation = userInputValidator.isValid(input);
			printLogWhenInvalid(validation);
		}
		return input;
	}

	public String enterInput() throws IOException {
		System.out.println(Message.INPUT.getMessage());
		return bufferedReader.readLine();
	}

	private void printLogWhenInvalid(boolean validation) {
		if (!validation) {
			System.out.println(Message.INVALID.getMessage());
		}
	}
}
