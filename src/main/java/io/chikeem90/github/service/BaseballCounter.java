package io.chikeem90.github.service;

import java.util.ArrayList;
import java.util.List;

import io.chikeem90.github.domain.BaseballCount;

public class BaseballCounter {
	public void processCount(List<Character> generatedNumber) {
		boolean isFind = false;
		while (!isFind) {
			List<Character> inputNumber = new ArrayList<>();
			String input = InOutputUtil.initInputNumber();
			this.initInputNumber(input, inputNumber);
			BaseballCount baseballCount = this.countBaseball(generatedNumber, inputNumber);
			InOutputUtil.printResult(baseballCount);
			isFind = baseballCount.isThreeStrike();
		}
	}

	private void initInputNumber(String input, List<Character> inputNumber) {
		for(char c : input.toCharArray()) {
			inputNumber.add(c);
		}
	}

	private BaseballCount countBaseball(List<Character> generatedNumber, List<Character> inputNumber) {
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < generatedNumber.size(); i++) {
			strike += countStrike(generatedNumber, inputNumber, i);
		}
		for (int i = 0; i < generatedNumber.size(); i++) {
			ball += countBall(generatedNumber, inputNumber, i);
		}
		return new BaseballCount(strike, ball);
	}

	private int countStrike(List<Character> generatedNumber, List<Character> inputNumber, int index) {
		if (generatedNumber.get(index) == inputNumber.get(index)) {
			return 1;
		}
		return 0;
	}

	private int countBall(List<Character> generatedNumber, List<Character> inputNumber, int index) {
		if (inputNumber.indexOf(generatedNumber.get(index)) != index && inputNumber.contains(generatedNumber.get(index))) {
			return 1;
		}
		return 0;
	}
}
