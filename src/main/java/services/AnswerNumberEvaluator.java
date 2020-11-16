package services;

import java.util.List;

public class AnswerNumberEvaluator {
	public Evaluation evaluate(String answerNumber, List<Integer> problemNumber) {
		int strikeCount = 0;
		int ballCount = 0;

		for (int i = 0; i < answerNumber.length(); i++) {
			strikeCount += getStrikeCount(answerNumber.charAt(i), problemNumber.get(i));
			ballCount += getBallCount(answerNumber.charAt(i), problemNumber);
		}

		return new Evaluation(strikeCount, ballCount - strikeCount);
	}

	private int getBallCount(char answerNumber, List<Integer> problemNumber) {
		if (problemNumber.contains(Character.getNumericValue(answerNumber))) {
			return 1;
		}
		return 0;
	}

	private int getStrikeCount(char answerNumber, int problemNumber) {
		if (problemNumber == Character.getNumericValue(answerNumber)) {
			return 1;
		}
		return 0;
	}
}
