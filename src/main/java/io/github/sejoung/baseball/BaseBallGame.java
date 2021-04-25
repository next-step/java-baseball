package io.github.sejoung.baseball;

import java.util.ArrayList;
import java.util.List;

import io.github.sejoung.baseball.constants.GameMessage;
import io.github.sejoung.baseball.constants.GameStatus;
import io.github.sejoung.baseball.constants.PlayMessage;
import io.github.sejoung.baseball.validator.BaseBallValidator;

public class BaseBallGame {
	private final TextOutput output;
	private final BaseBallGameComputerNumber baseBallGameComputerNumber;
	private final BaseBallGameStatus status;
	private final BaseBallValidator validator;

	public BaseBallGame(BaseBallNumberGenerator generator) {
		this.output = new TextOutput(GameMessage.INPUT);
		this.status = new BaseBallGameStatus();
		this.baseBallGameComputerNumber = new BaseBallGameComputerNumber(generator);
		this.validator = new BaseBallValidator(this.output, this.status);
	}

	public boolean isCompleted() {
		return false;
	}

	public String flushOutput() {
		return output.flush();
	}

	public void processInput(String input) {
		if (validator.validationInput(input) && !checkRestart()) {
			checkBaseBallNumbers(
				new BaseBallGamePlayerNumber(baseBallGameComputerNumber.getComputerNumbers(), output, status, input));
		}
	}

	public boolean checkRestart() {
		if (GameStatus.RESTART.equals(status.getStatus())) {
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
