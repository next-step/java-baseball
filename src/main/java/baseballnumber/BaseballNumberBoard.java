package baseballnumber;

public class BaseballNumberBoard {
	private final int strike;
	private final int ball;

	public BaseballNumberBoard(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public boolean isFinish() {
		return true;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
}
