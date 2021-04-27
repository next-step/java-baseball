package study;

public class Score {
	private final int strike;
	private final int ball;

	private Score(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	static Score strike() {
		return new Score(1, 0);
	}

	static Score ball() {
		return new Score(0, 1);
	}

	static Score zero() {
		return new Score(0, 0);
	}

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}

	public Score sumScore(Score other) {
		return new Score(this.strike + other.getStrike(), this.ball + other.getBall());
	}
}
