package com.gotgolem.baseball.asset.pitch;

public class PitchHint {

	private final int strikeCount;
	private final int ballCount;

	public PitchHint(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

}
