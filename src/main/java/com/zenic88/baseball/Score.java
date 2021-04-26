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

	@Override
	public String toString() {
		if (strike == 0 && ball == 0) {
			return "낫싱";
		}

		StringBuilder sb = new StringBuilder();
		if (strike > 0) {
			sb.append(strike).append(" 스트라이크");
		}
		if (ball > 0) {
			sb.append(" ").append(ball).append(" 볼");
		}

		return sb.toString().trim();
	}
}
