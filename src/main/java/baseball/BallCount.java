package baseball;

public class BallCount {
	private int strike;
	private int ball;

	public BallCount(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}
}
