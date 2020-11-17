package app;

public class GameResult {
	private int strikeCount;
	private int ballCount;
	private int nothingCount;

	public GameResult() {}

	public GameResult(int strikeCount, int ballCount, int nothingCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
		this.nothingCount = nothingCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public void setStrikeCount(int strikeCount) {
		this.strikeCount = strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public void setBallCount(int ballCount) {
		this.ballCount = ballCount;
	}

	public int getNothingCount() {
		return nothingCount;
	}

	public void setNothingCount(int nothingCount) {
		this.nothingCount = nothingCount;
	}

	@Override
	public String toString() {
		return String.format("%d %s, %d %s, %d %s 입니다.",
				strikeCount, JudgeType.STRIKE.name(),
				ballCount, JudgeType.BALL.name(),
				nothingCount, JudgeType.NOTHING.name());
	}

	public boolean isGameSuccess() {
		return this.getStrikeCount() == GameNumberRule.LENGTH.getValue();
	}
}
