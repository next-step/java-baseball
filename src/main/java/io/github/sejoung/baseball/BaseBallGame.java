package io.github.sejoung.baseball;

import java.util.ArrayList;
import java.util.List;

import io.github.sejoung.baseball.constants.GameMessage;
import io.github.sejoung.baseball.constants.PlayMessage;
import io.github.sejoung.baseball.constants.ValidatorMessage;

public class BaseBallGame {
	private static final String NEW_LINE = System.lineSeparator();

	private final StringBuffer output;
	private List<Integer> computerNumbers;

	public BaseBallGame(BaseBallNumberGenerator generator) {
		this.output = new StringBuffer(GameMessage.INPUT);
		this.computerNumbers = generator.generateBaseBallNumbers();
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
		if (validationInput(input)) {
			checkBaseBallNumbers(input);
		}
	}

	private boolean validationInput(String input) {
		return validationNumberFormat(input) && validationLength(input);
	}

	private boolean validationLength(String input) {
		if (input.length() != 3) {
			printMessages(ValidatorMessage.LENGTH, GameMessage.INPUT);
			return false;
		}
		return true;
	}

	private void checkBaseBallNumbers(String input) {
		List<Integer> playerNumbers = playerInputTransperList(input);
		if (computerNumbers.equals(playerNumbers)) {
			printMessages(PlayMessage.getStrike(3), GameMessage.SUCCESS, GameMessage.RESTART);
		}
	}

	private void printMessages(String... messages) {
		output.append(String.join(System.lineSeparator(), messages));
	}

	private List<Integer> playerInputTransperList(String input) {
		List<Integer> playerNumbers = new ArrayList<>();
		for (char number : input.toCharArray()) {
			playerNumbers.add(Character.getNumericValue(number));
		}
		return playerNumbers;
	}

	private boolean validationNumberFormat(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException exception) {
			printMessages(ValidatorMessage.NUMBER, GameMessage.INPUT);
			return false;
		}
	}
}
