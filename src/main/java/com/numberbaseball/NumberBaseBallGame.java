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

		int strike = 0;
		int ball = 0;
		for (int i = 0; i < NumberCreator.MAX_NUMBER_LENGTH; i++) {
			if (answerNumbers.get(i).intValue() == inputNumbers.get(i).intValue()) {
				strike++;
			} else if (answerNumbers.contains(inputNumbers.get(i))) {
				ball++;
			}
		}

		return NumberBaseBallResult.of(strike, ball);
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
