package services;

import java.util.List;

public class Evaluation {
	private int strikeCount;
	private int ballCount;

	public Evaluation() {
		this.strikeCount = 0;
		this.ballCount = 0;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public boolean doesHitAnswer() {
		return this.strikeCount == 3;
	}

	public void evaluate(String answerNumber, List<Integer> problemNumber) {
		int strikeCount = 0;
		int ballCount = 0;

		for (int i = 0; i < answerNumber.length(); i++) {
			strikeCount += getEvaluatedStrikeCount(answerNumber.charAt(i), problemNumber.get(i));
			ballCount += getEvaluatedBallCount(answerNumber.charAt(i), problemNumber);
		}

		this.strikeCount = strikeCount;
		this.ballCount = ballCount - strikeCount;
	}

	private int getEvaluatedBallCount(char answerNumber, List<Integer> problemNumber) {
		return problemNumber.contains(Character.getNumericValue(answerNumber)) ? 1 : 0;
	}

	private int getEvaluatedStrikeCount(char answerNumber, int problemNumber) {
		return problemNumber == Character.getNumericValue(answerNumber) ? 1 : 0;
	}
}
