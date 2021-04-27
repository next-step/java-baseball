package com.nextstep.precourse.computer;

public class BaseBallResult {
	private int strikeCount;
	private int containsCount;
	private String errorMessage;

	public BaseBallResult(int containsCount, int strikeCount, String errorMessage) {
		this.containsCount = containsCount;
		this.strikeCount = strikeCount;
		this.errorMessage = errorMessage;
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

	public String getErrorMessage(){
		return errorMessage;
	}
}
