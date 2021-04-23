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
		int index = 0;
		while (index < this.ballSize){
			checkStrike(baseballResult, index);
			checkBall(baseballResult, index);
			index++;
		}
		this.baseballResult = baseballResult;
	}

	private BaseballResult checkStrike(BaseballResult baseballResult, int index) {
		if(this.playerBallNumber.getNumberByIndex(index) == this.computerBallNumber.getNumberByIndex(index))
			baseballResult.addStrikeCount();
		return baseballResult;
	}

	private BaseballResult checkBall(BaseballResult baseballResult, int index) {
		return baseballResult;
	}
}
