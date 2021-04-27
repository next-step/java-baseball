package baseball.model;

public class BaseballResult {
	private final int strikeCount;
	private final int ballCount;

	public BaseballResult(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public boolean isAnswer() {
		return strikeCount == Baseball.ANSWER_SIZE;
	}

	public boolean hasStrike() {
		return strikeCount > 0;
	}

	public boolean hasBall() {
		return ballCount > 0;
	}

	public boolean isNothing() {
		return strikeCount == 0 && ballCount == 0;
	}
}
