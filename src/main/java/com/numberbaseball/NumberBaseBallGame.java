package com.numberbaseball;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseBallGame {

	public NumberBaseBallResult toResult(int answer, int input) {
		if (answer == input) {
			return NumberBaseBallResult.of(3, 0);
		}

		List<Integer> answerNumbers = eachNumberToList(answer);
		List<Integer> inputNumbers = eachNumberToList(input);

		return toNumberBaseBallResult(answerNumbers, inputNumbers);
	}

	private NumberBaseBallResult toNumberBaseBallResult(List<Integer> answerNumbers, List<Integer> inputNumbers) {
		int strike = 0;
		int strikeAndBall = 0;
		for (int i = 0; i < NumberCreator.MAX_NUMBER_LENGTH; i++) {
			strike += strikeCount(answerNumbers.get(i), inputNumbers.get(i));
			strikeAndBall += ballCount(answerNumbers, inputNumbers.get(i));
		}

		return NumberBaseBallResult.of(strike, strikeAndBall - strike);
	}

	private int ballCount(List<Integer> answerNumbers, int inputNumber) {
		return answerNumbers.contains(inputNumber) ? 1 : 0;
	}

	private int strikeCount(int answer, int number) {
		return answer == number ? 1 : 0;
	}

	private List<Integer> eachNumberToList(int number) {
		List<Integer> result = new ArrayList<>();
		for (int i = NumberCreator.MAX_NUMBER_LENGTH - 1; i >= 0; i--) {
			int eachNumber = number / (int)Math.pow(10, i);
			result.add(eachNumber);

			number = number % (eachNumber * (int)Math.pow(10, i));
		}
		return result;
	}

}
