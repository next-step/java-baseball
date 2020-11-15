public class BaseballScore {
	private int strike = 0;
	private int ball = 0;

	public int getStrike() {
		return strike;
	}

	public void addStrike() {
		this.strike++;
	}

	public int getBall() {
		return ball;
	}

	public void addBall() {
		this.ball++;
	}

	public void initialStrikeAndBall() {
		this.strike = 0;
		this.ball = 0;
	}
}
