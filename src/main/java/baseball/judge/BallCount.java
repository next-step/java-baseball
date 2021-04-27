package baseball.judge;

public class BallCount {
	private int strike;
	private int ball;

	public BallCount(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public int increaseStrike() {
		return this.strike++;
	}

	public int increaseBall() {
		return this.ball++;
	}

	public int getStrike() {
		return strike;
	}

	public void setStrike(int strike) {
		this.strike = strike;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}
}
