package com.woowahan.camp.model;

public class GameResult {
	private int strike;
	private int ball;

	private String computerValue;
	private String userValue;

	private GameResult(int strike, int ball, String computerValue, String userValue) {
		this.strike = strike;
		this.ball = ball;
		this.computerValue = computerValue;
		this.userValue = userValue;
	}

	public static GameResult of(int strike, int ball, String computerInputValue, String userInputValue) {
		return new GameResult(strike, ball, computerInputValue, userInputValue);
	}

	public boolean isWin() {
		return this.strike == 3;
	}

}
