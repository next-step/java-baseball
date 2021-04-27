package baseball;

public class Score {
	private int strikeCount;
	private int ballCount;

	public Score(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public int getStrikeCount() {
		return this.strikeCount;
	}

	public int getBallCount() {
		return this.ballCount;
	}

	public String getScoreMessage() {
		if (strikeCount == 0 && ballCount == 0) {
			return "포볼";
		}

		StringBuilder messageBuffer = new StringBuilder();
		if (strikeCount > 0) {
			messageBuffer.append(strikeCount).append(" 스트라이크");
		}
		if (strikeCount > 0 && ballCount > 0) {
			messageBuffer.append(" ");
		}
		if (ballCount > 0) {
			messageBuffer.append(ballCount).append("볼");
		}

		return messageBuffer.toString();
	}
}
