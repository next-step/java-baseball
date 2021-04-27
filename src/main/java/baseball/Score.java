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
}
