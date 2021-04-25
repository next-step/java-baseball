package io.github.sejoung.baseball.validator;

import io.github.sejoung.baseball.BaseBallGameStatus;
import io.github.sejoung.baseball.TextOutput;
import io.github.sejoung.baseball.constants.GameMessage;
import io.github.sejoung.baseball.constants.GameStatus;
import io.github.sejoung.baseball.constants.ValidatorMessage;

public class BaseBallValidator {
	private final TextOutput output;
	private final BaseBallGameStatus status;

	public BaseBallValidator(TextOutput output, BaseBallGameStatus status) {
		this.output = output;
		this.status = status;
	}

	public boolean validationInput(String input) {
		return validationNumberFormat(input) && validationLength(input);
	}

	private boolean validationNumberFormat(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException exception) {
			output.printMessages(ValidatorMessage.NUMBER, GameMessage.INPUT);
			return false;
		}
	}

	private boolean validationLength(String input) {
		if (!GameStatus.RESTART.equals(status.getStatus()) && input.length() != 3) {
			output.printMessages(ValidatorMessage.LENGTH, GameMessage.INPUT);
			return false;
		}
		return true;
	}
}
