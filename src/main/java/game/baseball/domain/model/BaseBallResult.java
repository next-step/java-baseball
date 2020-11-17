package game.baseball.domain.model;

public class BaseBallResult {
	private int strike = 0;
	private int ball = 0;

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}

	public void update(BaseBallStatus baseBallStatus) {
		if (baseBallStatus == BaseBallStatus.STRIKE) {
			this.strike++;
		} else if (baseBallStatus == BaseBallStatus.BALL) {
			this.ball++;
		}
	}
}
