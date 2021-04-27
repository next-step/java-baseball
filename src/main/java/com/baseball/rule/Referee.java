package com.baseball.rule;

import java.util.ArrayList;

public class Referee {

	private ArrayList<Integer> generatorNumbers;
	private ArrayList<Integer> playerNumbers;

	private int strike;
	private int ball;

	public Referee(ArrayList<Integer> generatorNumbers, ArrayList<Integer> playerNumbers) {
		this.generatorNumbers = generatorNumbers;
		this.playerNumbers = playerNumbers;

		strike = 0;
		ball = 0;
	}

	public void compareNumbers() {
		for (int i = 0; i < generatorNumbers.size(); i++) {
			countStrike(i);
			countBall(i, generatorNumbers.get(i));
		}
	}

	private void countBall(int i, Integer generatorNumber) {
		ArrayList<Integer> comparePlayerNumbers = new ArrayList<>(playerNumbers);
		comparePlayerNumbers.remove(i);
		if (comparePlayerNumbers.contains(generatorNumber)) {
			ball++;
		}
	}

	private void countStrike(int i) {
		if (generatorNumbers.get(i).equals(playerNumbers.get(i))) {
			strike++;
		}
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public String getResultMessage() {
		String message = "";
		if (strike == 0 && ball == 0) {
			return "낫싱";
		}
		if (strike > 0) {
			message += strike + " 스트라이크 ";
		}
		if (ball > 0) {
			message += ball + " 볼 ";
		}
		return message;
	}

	public boolean isStrikeOut() {
		return strike == 3;
	}

}
