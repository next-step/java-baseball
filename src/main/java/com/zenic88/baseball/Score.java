package com.zenic88.baseball;

public class Score {

	private int strike;
	private int ball;

	public int getStrike() {
		return strike;
	}

	public void addStrike() {
		this.strike++;
	}

	public int getBall() {
		return ball;
	}

	public void addBall() {
		this.ball++;
	}
}
