import java.util.List;

public class Score {
	private static final String BALL_TEXT = " 볼";
	private static final String STRIKE_TEXT = " 스트라이크 ";
	private static final String FOUR_BALL = "포볼";

	private int ballCount;
	private int strikeCount;
	private String scoreText = "";

	public boolean isAllStrike() {
		return strikeCount == 3;
	}

	public String calculateScore() {
		if (ballCount == 0 && strikeCount == 0) {
			return FOUR_BALL;
		}

		calculateStrikeCount();
		calculateBallCount();

		return scoreText;
	}

	public void setCounts(List<Integer> computerBalls, int ballIndex, Integer ball) {
		Integer computerBall = computerBalls.get(ballIndex);
		addStrikeCount(computerBall, ball);
		addBallCount(computerBalls, ball);
	}

	private void calculateStrikeCount() {
		if (strikeCount == 0) {
			return;
		}

		scoreText += strikeCount + STRIKE_TEXT;
	}

	private void calculateBallCount() {
		if (ballCount == 0) {
			return;
		}

		scoreText += ballCount + BALL_TEXT;
	}

	private void addStrikeCount(int a, int b) {
		if (a == b) {
			strikeCount++;
		}
	}

	private void addBallCount(List<Integer> items, int b) {
		if (items.contains(b)) {
			ballCount++;
		}
	}


}
