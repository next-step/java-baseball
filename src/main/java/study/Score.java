package study;

public class Score {
	private static final Score NOTHING = new Score(0, 0);
	private static final Score STRIKE = new Score(1, 0);
	private static final Score BALL = new Score(0, 1);

	private final int strike;
	private final int ball;

	private Score(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	static Score strike() {
		return STRIKE;
	}

	static Score ball() {
		return BALL;
	}

	static Score nothing() {
		return NOTHING;
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

	@Override
	public String toString() {
		return "Score{strike=" + strike + ", ball=" + ball + '}';
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		Score score = (Score)other;
		return strike == score.strike && ball == score.ball;
	}
}
