package exam.baseball;

public class Score {
	private int ball;
	private int strike;

	public Score(int strike, int ball) {
		super();
		this.strike = strike;
		this.ball = ball;
	}

	public int getBall() {
		return ball;
	}

	public int getStrike() {
		return strike;
	}

}
