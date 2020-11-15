public class BaseballResult {

	private final int strikeCount;
	private final int ballCount;

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public BaseballResult(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public boolean isNothing() {
		return this.strikeCount == 0 && this.ballCount == 0;
	}
}
