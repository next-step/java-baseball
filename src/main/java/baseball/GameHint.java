package baseball;

public class GameHint {
	private int strikeCount = 0;
	private int ballCount = 0;

	public GameHint(String answer, String input) {
		String[] answers = answer.split("");
		String[] inputs = input.split("");

		countStrike(answers, inputs);
		countBall(answers, inputs);
	}

	private void countBall(String[] answers, String[] inputs) {
		for (int i = 0, size = answers.length; i < size; i++) {
			addBallCount(answers, inputs[i]);
		}
		ballCount = ballCount - strikeCount;
	}

	private void addBallCount(String[] answers, String input) {
		for (String answer : answers) {
			addBallCount(answer, input);
		}
	}

	private void addBallCount(String answer, String input) {
		if (answer.equals(input)) {
			ballCount++;
		}
	}

	public void countStrike(String[] answers, String[] inputs) {
		for (int i = 0, answersSize = answers.length; i < answersSize; i++) {
			addStrikeCount(answers[i], inputs[i]);
		}
	}

	private void addStrikeCount(String answer, String input) {
		if (answer.equals(input)) {
			strikeCount++;
		}
	}

	public int countStrike() {
		return strikeCount;
	}

	public int countBall() {
		return ballCount;
	}

	public boolean isNothing() {
		return (ballCount == 0) && (strikeCount == 0);
	}
}
