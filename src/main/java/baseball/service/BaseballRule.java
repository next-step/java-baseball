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

	//todo: indent < 2 줄여야 합니다. refactoring 필요
	private void compareBallNumbers() {
		BaseballResult baseballResult = new BaseballResult();
		int playerIndex = 0;
		while (playerIndex < BallNumber.MIN_SIZE) {
			checkStrike(baseballResult, playerIndex);
			checkBall(baseballResult, playerIndex);
			playerIndex++;
		}
		this.baseballResult = baseballResult;
	}

	private BaseballResult checkStrike(BaseballResult baseballResult, int playerIndex) {
		if (this.playerBallNumber.getNumberByIndex(playerIndex) == this.computerBallNumber.getNumberByIndex(playerIndex))
			baseballResult.addStrikeCount();
		return baseballResult;
	}

	private BaseballResult checkBall(BaseballResult baseballResult, int playerIndex) {
		int frontComputerIndex = getFrontComputerIndexByPlayerIndex(playerIndex);
		int backComputerIndex = getBackComputerIndexByPlayerIndex(playerIndex);
		if (this.playerBallNumber.getNumberByIndex(playerIndex) == this.computerBallNumber.getNumberByIndex(frontComputerIndex))
			baseballResult.addBallCount();
		if (this.playerBallNumber.getNumberByIndex(playerIndex) == this.computerBallNumber.getNumberByIndex(backComputerIndex) && backComputerIndex >= BallNumber.MIN_SIZE)
			baseballResult.addBallCount();
		return baseballResult;
	}

	private int getFrontComputerIndexByPlayerIndex(int playerIndex) {
		int frontComputerIndex = playerIndex;
		frontComputerIndex++;
		if (frontComputerIndex == BallNumber.MAX_SIZE)
			frontComputerIndex = 0;
		return frontComputerIndex;
	}

	private int getBackComputerIndexByPlayerIndex(int playerIndex) {
		int backComputerComputerIndex = playerIndex;
		backComputerComputerIndex--;
		return backComputerComputerIndex;
	}

}
