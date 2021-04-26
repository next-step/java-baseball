public class GameResult {
	private static final int NO_STRIKE = 0;
	private static final int NO_BALL = 0;
	private static final int STRIKE_OUT = 3;

	private static final String STRIKE_OUT_COMMENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String FOUR_BALL_COMMENT = "4볼";

	private int strike;
	private int ball;

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

	public boolean isFourBall() {
		return (strike == NO_STRIKE && ball == NO_BALL) ? true : false;
	}

	public boolean isStrikeOut() {
		return (strike == STRIKE_OUT) ? true : false;
	}

	public String print() {
		if (isStrikeOut()) {
			return STRIKE_OUT_COMMENT;
		}
		if (isFourBall()) {
			return FOUR_BALL_COMMENT;
		}
		return makeResultComment(strike, ball);
	}

	private String makeResultComment(int strike, int ball) {
		String result = (strike > NO_STRIKE) ? strike + " 스트라이크 " : "";

		if (ball > NO_BALL) {
			result += ball + "볼";
		}

		return result;
	}
};
