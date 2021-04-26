package baseballgame;

public class BaseBallResult {
	private int strikeCount;
	private int containsCount;

	public BaseBallResult(int containsCount, int strikeCount) {
		this.containsCount = containsCount;
		this.strikeCount = strikeCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return containsCount - strikeCount;
	}

	public boolean isNothing() {
		return strikeCount + getBallCount() == 0;
	}
}
