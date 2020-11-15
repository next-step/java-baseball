package edu.nextstep.game;

public class BaseballScore {
	private int maxStrike;
	private int strike;
	private int ball;

	public BaseballScore(int numberSize) {
		this.maxStrike = numberSize;
	}

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
