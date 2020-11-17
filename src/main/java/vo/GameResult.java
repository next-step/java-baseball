package vo;

import constants.GameNumberRule;
import constants.JudgeType;

public class GameResult {
	private int strikeCount;
	private int ballCount;
	private int nothingCount;

	public GameResult(int strikeCount, int ballCount, int nothingCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
		this.nothingCount = nothingCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public int getNothingCount() {
		return nothingCount;
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
