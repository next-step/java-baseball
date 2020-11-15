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

	public String toLocaleString() {
		if (strike > 0 && ball > 0) {
			return strike + " 스트라이크 " + ball + "볼";
		}
		if (strike > 0) {
			return strike + " 스트라이크";
		}
		if (ball > 0) {
			return ball + "볼";
		}
		return "낫싱";
	}
}
