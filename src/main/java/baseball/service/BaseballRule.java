package baseball.service;

import baseball.domain.BallNumber;
import baseball.domain.BaseballResult;

public class BaseballRule {

	private BallNumber playerBallNumber;
	private BallNumber computerBallNumber;
	private BaseballResult baseballResult;
	private int ballSize;

	public BaseballRule(BallNumber playerBallNumber, BallNumber computerBallNumber) {
		this.playerBallNumber = playerBallNumber;
		this.computerBallNumber = computerBallNumber;
		this.ballSize = BallNumber.SIZE;
		compareBallNumbers();
	}

	public BaseballResult getResult() {
		return this.baseballResult;
	}

	//todo: indent < 2 줄여야 합니다. refactoring 필요
	private void compareBallNumbers() {
		BaseballResult baseballResult = new BaseballResult();
		int playerIndex = 0;
		while (playerIndex < this.ballSize) {
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
		int computerIndex = playerIndex;
		computerIndex++;
		if(computerIndex == this.ballSize)
			computerIndex = 0;
		if(this.playerBallNumber.getNumberByIndex(playerIndex) == this.computerBallNumber.getNumberByIndex(computerIndex) )
			baseballResult.addBallCount();
		return baseballResult;
	}
}
