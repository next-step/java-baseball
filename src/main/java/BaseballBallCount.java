public class BaseballBallCount {

	int strikeCount;
	int ballCount;

	public BaseballBallCount() {
		initBallCount();
	}

	private void initBallCount() {
		strikeCount = 0;
		ballCount = 0;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	private void callStrike() {
		strikeCount ++;
	}

	private void callBall() {
		ballCount ++;
	}

	public void setCallSign(String answer, String attackKeyword) {
		initBallCount();

		for (int i = 0; i < attackKeyword.length(); i++) {
			char attackBall = attackKeyword.charAt(i);
			int targetPosition = answer.indexOf(attackBall);

			judgeBallCount(i, targetPosition);
		}
	}

	private void judgeBallCount(int i, int targetPosition) {
		if (targetPosition == -1) {
			return;
		}

		if (targetPosition == i) {
			callStrike();
			return;
		}

		callBall();
	}

	public String getCallSign() {
		if (strikeCount == 0 && ballCount == 0) {
			return "낫싱";
		}

		String callSign = "";

		callSign = callSignStrikes(callSign);
		callSign = callSignBalls(callSign);
		return callSign;
	}

	private String callSignBalls(String callSign) {
		if (ballCount > 0) {
			callSign = setSeparator(callSign);
			callSign = callSign.concat(ballCount + "볼");
		}
		return callSign;
	}

	private String callSignStrikes(String callSign) {
		if (strikeCount > 0) {
			callSign = callSign.concat(strikeCount + "스트라이크");
		}
		return callSign;
	}

	private String setSeparator(String callSign) {
		return callSign.length() > 0 ? callSign.concat(" ") : callSign;
	}
}
