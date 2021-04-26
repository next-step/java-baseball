package com.precourse.baseball;

import java.util.List;

public class Hint {
	public int strike;
	public int ball;
	private final List<Integer> com;
	private final List<Integer> user;

	public Hint(List<Integer> com, List<Integer> user) {
		this.com = com;
		this.user = user;
		this.strike = countStrike();
		this.ball = countBall();
	}

	/**
	 * 스트라이크 갯수 계산 후 반환
	 * @return 스트라이크 갯수
	 */
	public int countStrike() {
		strike = 0;
		for (int i = 0; i < Constants.LENGTH_OF_NUMBER; i++) {
			strike += com.get(i).equals(user.get(i)) ? 1 : 0;
		}
		return strike;
	}

	/**
	 * 볼 갯수 계산 후 반환
	 * @return 볼 갯수
	 */
	public int countBall() {
		int count = 0;
		for (int num : user) {
			count += com.contains(num) ? 1 : 0;
		}
		ball = count - strike;
		return ball;
	}

	/**
	 * 스트라이크와 볼 갯수에 따른 문자열 반환
	 * @return 힌트 문자열
	 */
	public String getHint() {
		if (strike == 0 && ball == 0) {
			return Constants.NO_BALL_NO_STRIKE;
		}
		if (strike == 0) {
			return String.format(Constants.BALL_ONLY, ball);
		}
		if (ball == 0) {
			return String.format(Constants.STRIKE_ONLY, strike);
		}
		return String.format(Constants.STRIKE_N_BALL, strike, ball);
	}

}
