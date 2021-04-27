package baseball.service;

import baseball.domain.BallNumber;
import baseball.domain.BaseballResult;

public class BaseballRule {

	private BallNumber playerBallNumber;
	private BallNumber computerBallNumber;
	private BaseballResult baseballResult;

	public BaseballRule(BallNumber playerBallNumber, BallNumber computerBallNumber) {
		this.playerBallNumber = playerBallNumber;
		this.computerBallNumber = computerBallNumber;
		compareBallNumbers();
	}

	public BaseballResult getResult() {
		return this.baseballResult;
	}

	private void compareBallNumbers() {
		this.baseballResult = new BaseballResult();
		int playerIndex = BallNumber.MIN_SIZE;
		while (playerIndex < BallNumber.MAX_SIZE) {
			checkStrike(playerIndex);
			checkBall(playerIndex);
			playerIndex++;
		}
	}

	private BaseballResult checkStrike(int playerIndex) {
		if (this.playerBallNumber.getNumberByIndex(playerIndex) == this.computerBallNumber.getNumberByIndex(playerIndex))
			this.baseballResult.addStrikeCount();
		return this.baseballResult;
	}

	private BaseballResult checkBall(int playerIndex) {
		checkBallFrontNumber(playerIndex);
		checkBallBackNumber(playerIndex);
		return this.baseballResult;
	}

	private void checkBallFrontNumber(int playerIndex) {
		int frontComputerIndex = getFrontComputerIndex(playerIndex);
		if (this.playerBallNumber.getNumberByIndex(playerIndex) == this.computerBallNumber.getNumberByIndex(frontComputerIndex))
			this.baseballResult.addBallCount();
	}

	private void checkBallBackNumber(int playerIndex) {
		int backComputerIndex = getBackComputerIndex(playerIndex);
		if (this.playerBallNumber.getNumberByIndex(playerIndex) == this.computerBallNumber.getNumberByIndex(backComputerIndex))
			this.baseballResult.addBallCount();
	}

	private int getFrontComputerIndex(int playerIndex) {
		int frontComputerIndex = playerIndex;
		frontComputerIndex++;
		if (frontComputerIndex == BallNumber.MAX_SIZE)
			frontComputerIndex = BallNumber.MIN_SIZE;
		return frontComputerIndex;
	}

	private int getBackComputerIndex(int playerIndex) {
		int backComputerComputerIndex = playerIndex;
		backComputerComputerIndex--;
		if (backComputerComputerIndex < BallNumber.MIN_SIZE)
			backComputerComputerIndex = BallNumber.MAX_SIZE - 1;
		return backComputerComputerIndex;
	}

}
