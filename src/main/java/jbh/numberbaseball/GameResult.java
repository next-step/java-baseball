package jbh.numberbaseball;

public class GameResult {

	private int strikeCount;
	private int ballCount;

	public GameResult(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public int getStrikeCount() {
		return this.strikeCount;
	}

	public int getBallCount() {
		return this.ballCount;
	}

	public boolean hasStrike() {
		return this.strikeCount > 0;
	}

	public boolean hasBall() {
		return this.ballCount > 0;
	}

	public boolean isNothing() {
		return this.ballCount == 0 && this.strikeCount == 0;
	}

	public boolean isOut() {
		return this.strikeCount == 3;
	}
}
