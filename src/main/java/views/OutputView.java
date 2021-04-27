package views;

public class OutputView {
	public void printEvaluation(int strikeCount, int ballCount) {
		String displayString = checkStrikeNumber(strikeCount) +
				checkBallNumber(ballCount) +
				checkNothing(strikeCount, ballCount) +
				"\n" +
				checkHitAnswer(strikeCount);

		System.out.println(displayString);
	}

	private String checkNothing(int strikeCount, int ballCount) {
		return (strikeCount == 0 && ballCount == 0) ? Constants.NOTHING : "";
	}

	private String checkHitAnswer(int strikeCount) {
		return strikeCount == 3 ? Constants.HIT_ANSWER : "";
	}

	private String checkStrikeNumber(int strikeCount) {
		return strikeCount > 0 ? strikeCount + Constants.STRIKE : "";
	}

	private String checkBallNumber(int ballCount) {
		return ballCount > 0 ? ballCount + Constants.BALL : "";
	}
}
