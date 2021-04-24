package baseball;

public class BallCount {
	private int strike;
	private int ball;

	public BallCount() {
		this.strike = 0;
		this.ball = 0;
	}

	public BallCount(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public void setStrike(int strike) {
		this.strike = strike;
	}

	public int getStrike() {
		return this.strike;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}

	public int getBall() {
		return this.ball;
	}

	public void add(BallCount ballCount) {
		this.strike += ballCount.getStrike();
		this.ball += ballCount.getBall();
	}
}
