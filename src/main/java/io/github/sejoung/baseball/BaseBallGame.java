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
		if (validator.validationInput(input)) {
			checkBaseBallNumbers(input);
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

	private void checkBaseBallNumbers(String input) {
		if (!checkRestart()) {
			List<Integer> playerNumbers = playerInputTransperList(input);
			int strikeCount = strikeCheck(playerNumbers);
			int ballCount = 0;
			printPlayMessage(strikeCount, ballCount);
		}
	}

	private void printPlayMessage(int strikeCount, int ballCount) {
		if (strikeCount == 3) {
			output.printMessages(PlayMessage.getStrike(3), GameMessage.SUCCESS, GameMessage.RESTART);
		}
	}

	private int strikeCheck(List<Integer> playerNumbers) {
		return threeStrikeCheck(playerNumbers);
	}

	private int threeStrikeCheck(List<Integer> playerNumbers) {
		if (baseBallGameComputerNumber.getComputerNumbers().equals(playerNumbers)) {
			status.restartGame();
			return 3;
		}
		return 0;
	}

	private List<Integer> playerInputTransperList(String input) {
		List<Integer> playerNumbers = new ArrayList<>();
		for (char number : input.toCharArray()) {
			playerNumbers.add(Character.getNumericValue(number));
		}
		return playerNumbers;
	}

}
