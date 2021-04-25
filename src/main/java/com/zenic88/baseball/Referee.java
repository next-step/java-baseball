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
		if (score.getStrike() == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}
		return false;
	}
}
