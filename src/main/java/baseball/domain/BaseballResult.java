package baseball.domain;

import baseball.domain.BallNumber;

public class BaseballResult {

	private int strikeCount;
	private int ballCount;

	public BaseballResult() {
		this.strikeCount = 0;
		this.ballCount = 0;
	}

	public void addStrikeCount() {
		this.strikeCount++;
	}

	public void addBallCount() {
		this.ballCount++;
	}

	public int getStrikeCount() {
		return this.strikeCount;
	}

	public int getBallCount() {
		return this.ballCount;
	}

}
