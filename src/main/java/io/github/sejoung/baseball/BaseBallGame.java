package io.github.sejoung.baseball;

import io.github.sejoung.baseball.constants.GameMessage;
import io.github.sejoung.baseball.constants.GameStatus;
import io.github.sejoung.baseball.validator.BaseBallValidator;

public class BaseBallGame {
	private final TextOutput output;
	private final BaseBallGameComputerNumber baseBallGameComputerNumber;
	private final BaseBallGameStatus status;
	private final BaseBallValidator validator;

	boolean isCompleted = false;

	public BaseBallGame(BaseBallNumberGenerator generator) {
		this.output = new TextOutput(GameMessage.INPUT);
		this.status = new BaseBallGameStatus();
		this.baseBallGameComputerNumber = new BaseBallGameComputerNumber(generator);
		this.validator = new BaseBallValidator(this.output, this.status);
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public String flushOutput() {
		return output.flush();
	}

	public void processInput(String input) {
		if (validator.validationInput(input) && !checkRestart(input)) {
			checkBaseBallNumbers(
				new BaseBallGamePlayerNumber(baseBallGameComputerNumber.getComputerNumbers(), output, status, input));
		}
	}

	public boolean checkRestart(String input) {
		if ("2".equals(input)) {
			isCompleted = true;
			return true;
		}
		if ("1".equals(input) && GameStatus.RESTART.equals(status.getStatus())) {
			status.playGame();
			baseBallGameComputerNumber.changeBaseBallGameComputerNumber();
			output.printMessages(GameMessage.INPUT);
			return true;
		}
		return false;
	}

	private void checkBaseBallNumbers(BaseBallGamePlayerNumber baseBallGamePlayerNumber) {
		baseBallGamePlayerNumber.check();
	}
}
