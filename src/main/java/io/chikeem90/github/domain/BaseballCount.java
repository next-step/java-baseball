package io.chikeem90.github.domain;

public class BaseballCount {
	private int strikeCount;
	private int ballCount;

	public BaseballCount(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
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

	public boolean isNoting() {
		return this.strikeCount == 0 && this.ballCount == 0;
	}

	public boolean isThreeStrike() {
		return this.strikeCount == 3;
	}
}
