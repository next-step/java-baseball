package util;

public class NumberBaseballGameGuessCalculator {
	// example 1: it returns 0, when targetNumbers: 719, inputNumbers: 121
	static public int calculateStrikeCount(int[] targetNumbers, int[] inputNumbers) {
		int count = 0;

		for (int i = 0; i < inputNumbers.length; i++) {
			count += isStrike(targetNumbers, inputNumbers[i], i) ? 1 : 0;
		}

		return count;
	}

	/*
		example 1: it returns 2, when targetNumbers: 719, inputNumbers: 121
		example 2: it returns 2, when targetNumbers: 719, inputNumbers: 111
	*/
	static public int calculateBallCount(int[] targetNumbers, int[] inputNumbers) {
		int count = 0;

		for (int i = 0; i < targetNumbers.length; i++) {
			count += isBall(targetNumbers, inputNumbers[i], i) ? 1 : 0;
		}

		return count;
	}

	static private boolean isStrike(int[] targetNumbers, int inputNumber, int index) {
		return targetNumbers[index] == inputNumber;
	}

	static private boolean isBall(int[] targetNumbers, int inputNumber, int index) {
		if (targetNumbers[index] == inputNumber) {
			return false;
		}

		return NumberBaseballGameTypeConverter.convertIntArrayToSet(targetNumbers).contains(inputNumber);
	}
}
