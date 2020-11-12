package baseball;

public class GameHint {
	private int strikeCount = 0;

	public GameHint(String answer, String input) {
		String[] answers = answer.split("");
		String[] inputs = input.split("");

		countStrike(answers, inputs);
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
}
