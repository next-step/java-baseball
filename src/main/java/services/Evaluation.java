package services;

public class Evaluation {
	private final int strikeCount;
	private final int ballCount;

	public Evaluation() {
		this.strikeCount = 0;
		this.ballCount = 0;
	}

	public Evaluation(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public boolean doesHitAnswer() {
		return this.strikeCount == 3;
	}
}
