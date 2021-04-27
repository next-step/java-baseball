package umpire;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Umpire {

	private List<Integer> targetNumber;
	private Set<Integer> checkSet = new HashSet<>();

	public Umpire(List<Integer> targetNumber) {
		this.targetNumber = targetNumber;
	}

	public boolean check(List<Integer> inputNumber) {
		init(inputNumber);
		int strike = checkStrike(inputNumber);
		int ball = checkBall(inputNumber, strike);
		printResult(strike, ball);
		return strike == 3;
	}

	private void init(List<Integer> inputNumber) {
		checkSet.clear();
		for (int i = 0; i < inputNumber.size(); i++) {
			checkSet.add(targetNumber.get(i));
			checkSet.add(inputNumber.get(i));
		}
	}

	protected int checkStrike(List<Integer> inputNumber) {
		int strikeCount = 0;
		for (int i = 0; i < inputNumber.size(); i++) {
			strikeCount += targetNumber.get(i) == inputNumber.get(i) ? 1 : 0;
		}
		return strikeCount;
	}

	protected int checkBall(List<Integer> inputNumber, int strike) {
		return targetNumber.size() + inputNumber.size() - strike - checkSet.size();
	}

	private void printResult(int strike, int ball) {
		String resultTxt = "";
		if (strike != 0) {
			resultTxt += strike + " 스트라이크 ";
		}
		;
		if (ball != 0) {
			resultTxt += ball + " 볼";
		}
		if (strike == 0 && ball == 0) {
			resultTxt = "낫싱";
		}
		System.out.println(resultTxt);
	}
}
