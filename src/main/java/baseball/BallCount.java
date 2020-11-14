package baseball;

public class BallCount {

	public static final int BALL_COUNT_SIZE = 3;

	private int strike;
	private int ball;

	public BallCount() {
		this.strike = 0;
		this.ball = 0;
	}

	public BallCount(final int strike, final int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public boolean isNoting() {
		return strike == 0 && ball == 0 ? true : false;
	}

	public boolean isEndGame() {
		return strike == 3 ? true : false;
	}

	public boolean hasStrike() {
		return strike > 0 ? true : false;
	}

	public boolean hasBall() {
		return ball > 0 ? true : false;
	}

	public void addStrike() {
		this.strike++;
	}

	public void addBall() {
		this.ball++;
	}

	public String getStrikeText() {
		return new StringBuilder()
			.append(strike)
			.append(GameResource.TEXT_STRIKE)
			.append(GameResource.TEXT_BLANK)
			.toString();
	}

	public String getBallText() {
		return new StringBuffer()
			.append(ball)
			.append(GameResource.TEXT_BALL)
			.append(GameResource.TEXT_BLANK)
			.toString();
	}

	@Override
	public String toString() {
		return new StringBuilder()
			.append(strike)
			.append("S")
			.append(ball)
			.append("B")
			.toString();
	}
}
