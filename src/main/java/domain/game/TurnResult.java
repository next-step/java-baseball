package domain.game;

public class TurnResult {
	private int ballCount;
	private int strikeCount;

	public int getBallCount() {
		return ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public TurnResult(int ballCount, int strikeCount) {
		this.ballCount = ballCount;
		this.strikeCount = strikeCount;
	}

	public boolean isNothing() {
		return this.getBallCount() == 0 && this.getStrikeCount() == 0;
	}
}
