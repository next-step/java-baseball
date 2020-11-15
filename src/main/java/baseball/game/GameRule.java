package baseball.game;

import static baseball.constants.GameConstants.*;

import baseball.player.Computer;
import baseball.player.User;

public class GameRule {
	private User user;
	private Computer computer;
	private GameCount gameCount;

	public GameRule(Game game) {
		user = game.getUser();
		computer = game.getComputer();
	}

	public GameCount judgeGameCount() {
		gameCount = new GameCount();
		if (isThreeStrike()) {
			return gameCount;
		}
		judgeGameCountDetail();
		return gameCount;
	}

	private boolean isThreeStrike() {
		if (computer.getNumber().equals(user.getNumber())) {
			gameCount.setStrikeCount(MAX_COUNT_STRIKE);
			return true;
		}
		return false;
	}

	private void judgeGameCountDetail() {
		iterateComputerNumber();
	}

	private void iterateComputerNumber() {
		while (gameCount.getComputerIndex() < computer.getNumber().length()) {
			gameCount.initUserIndex();
			iterateUserNumber(gameCount.getComputerIndex());
			gameCount.addComputerIndex();
		}
	}

	private void iterateUserNumber(int computerIndex) {
		while (gameCount.getUserIndex() < user.getNumber().length()) {
			judgeStrikeOrBall(computerIndex, gameCount.getUserIndex());
		}
	}

	private void judgeStrikeOrBall(int computerIndex, int userIndex) {
		if (isStrike(computerIndex, userIndex) || isBall(computerIndex, userIndex)) {
			gameCount.overUserIndex();
			return;
		}
		gameCount.addUserIndex();
	}

	private boolean isStrike(int computerIndex, int userIndex) {
		if (computerIndex == userIndex && equalsByIndex(computerIndex, userIndex)) {
			gameCount.addStrikeCount();
			return true;
		}
		return false;
	}

	private boolean isBall(int computerIndex, int userIndex) {
		if (equalsByIndex(computerIndex, userIndex)) {
			gameCount.addBallCount();
			return true;
		}
		return false;
	}

	private boolean equalsByIndex(int computerIndex, int userIndex) {
		return computer.getNumber().toCharArray()[computerIndex] == user.getNumber().toCharArray()[userIndex];
	}
}
