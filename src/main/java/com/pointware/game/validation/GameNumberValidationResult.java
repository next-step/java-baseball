package com.pointware.game.validation;

public class GameNumberValidationResult {
	private int strikeCount;
	private int ballCount;

	public GameNumberValidationResult(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public boolean isNothing() {
		return strikeCount + ballCount == 0;
	}

	public boolean isEnd() {
		return this.strikeCount == 3;
	}
}
