package io.github.sejoung.baseball;

import io.github.sejoung.baseball.constants.GameMessage;
import io.github.sejoung.baseball.constants.ValidatorMessage;

public class BaseBallGame {
	private static final String NEW_LINE = System.lineSeparator();

	private final StringBuffer output;

	public BaseBallGame(BaseBallNumberGenerator generator) {
		this.output = new StringBuffer(GameMessage.INPUT);
	}

	public boolean isCompleted() {
		return false;
	}

	public String flushOutput() {
		String message = output.toString();
		output.setLength(0);
		return message;
	}

	public void processInput(String input) {
		if (!validationNumberFormat(input)) {
			output.append(ValidatorMessage.NUMBER);
			output.append(NEW_LINE);
			output.append(GameMessage.INPUT);
		} else if (input.length() != 3) {
			output.append(ValidatorMessage.LENGTH);
			output.append(NEW_LINE);
			output.append(GameMessage.INPUT);
		}
	}

	private boolean validationNumberFormat(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException exception) {
			return false;
		}
	}
}
