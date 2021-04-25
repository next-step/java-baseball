package com.numberbaseball;

import jdk.internal.joptsimple.internal.Strings;

public class NumberBaseBallResult {
	private int strike;
	private int ball;

	private NumberBaseBallResult(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public static NumberBaseBallResult of(int strike, int ball) {
		return new NumberBaseBallResult(strike, ball);
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public String toStr() {
		if (isNothing()) {
			return "낫싱";
		}
		return strikeToResultString() + appendSpaceIfExistStrikeAndBall() + ballToResultString();
	}

	private boolean isNothing() {
		return this.strike == 0 && this.ball == 0;
	}

	private String ballToResultString() {
		if (this.ball > 0) {
			return this.ball + "볼";
		}
		return Strings.EMPTY;
	}

	private String appendSpaceIfExistStrikeAndBall() {
		if (this.strike > 0 && this.ball > 0) {
			return " ";
		}
		return Strings.EMPTY;
	}

	private String strikeToResultString() {
		if (this.strike > 0) {
			return this.strike + " 스트라이크";
		}
		return Strings.EMPTY;
	}
}
