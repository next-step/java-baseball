package baseball.report;

public class Report {
	public static final Report EMPTY = new Report(0, 0);
	private Integer strike;
	private Integer ball;

	public Report(Integer strike, Integer ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public boolean isFourBall() {
		return ball.equals(0) && strike.equals(0);
	}

	public boolean isStrikeOut() {
		return strike.equals(3);
	}

	public Integer getStrike() {
		return strike;
	}

	public Integer getBall() {
		return ball;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendStrikeMessage(sb);
		appendBallMessage(sb);
		appendFourMessage(sb);

		return sb.toString();
	}

	private void appendFourMessage(StringBuilder sb) {
		if (isFourBall())
			sb.append("포볼");
	}

	private void appendBallMessage(StringBuilder sb) {
		if (ball > 0)
			sb.append(ball).append("볼");
	}

	private void appendStrikeMessage(StringBuilder sb) {
		if (strike > 0)
			sb.append(strike).append("스트라이크");
	}

	public boolean isContinues() {
		return !isStrikeOut();
	}
}
