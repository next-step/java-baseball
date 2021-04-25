package com.zenic88.baseball;

import java.util.List;

public class Referee {

	public Score check(Score score, List<Integer> numberList, int userValue, int count) {

		if (isStrike(numberList, userValue, count)) {
			score.addStrike();
			return score;
		}

		if (isBall(numberList, userValue)) {
			score.addBall();
			return score;
		}

		return score;
	}

	private boolean isStrike(List<Integer> numberList, int userNumber, int count) {
		return numberList.get(count) == userNumber;
	}

	private boolean isBall(List<Integer> numberList, int userNumber) {
		return numberList.contains(userNumber);
	}

	public boolean isEnd(Score score) {
		return score.getStrike() == 3;
	}
}
