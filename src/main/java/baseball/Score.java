package baseball;

public class Score {
	private static final String BALL_TEXT = " 볼";
	private static final String STRIKE_TEXT = " 스트라이크 ";
	private static final String FOUR_BALL = "포볼";

	private int ballCount;
	private int strikeCount;
	private String scoreText = "";

	public boolean isStrikeout() {
		return strikeCount == 3;
	}

	public String calculateScore() {
		if (ballCount == 0 && strikeCount == 0) {
			return FOUR_BALL;
		}

		setStrikeCountText();
		setBallCountText();

		return scoreText;
	}

	private void setStrikeCountText() {
		if (strikeCount == 0) {
			return;
		}

		scoreText += strikeCount + STRIKE_TEXT;
	}

	private void setBallCountText() {
		if (ballCount == 0) {
			return;
		}

		scoreText += ballCount + BALL_TEXT;
	}

	public void addStrike() {
		strikeCount++;
	}

	public void addBall() {
			ballCount++;
	}


}
