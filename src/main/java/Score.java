public class Score {
	private static final String BALL_TEXT = " 볼";
	private static final String STRIKE_TEXT = " 스트라이크";
	private static final String FOUR_BALL = "포볼";

	private int ballCount;
	private int strikeCount;
	private String ballMessage;
	private String strikeMessage;

	public void addBall() {
		ballMessage = ++ballCount + BALL_TEXT;
	}

	public void addStrike() {
		strikeMessage = ++strikeCount + STRIKE_TEXT;
	}

	public boolean isAllStrike() {
		return strikeCount == 3;
	}

	public String getScoreString() {
		if (ballCount == 0 && strikeCount == 0) {
			return FOUR_BALL;
		}

		return removeEmpty(strikeMessage + " " + ballMessage);
	}

	private String removeEmpty(String text) {
		return text.replace("null", "").trim();
	}
}
