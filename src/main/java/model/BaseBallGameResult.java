package model;

public class BaseBallGameResult {

	private static final int ANSWER_COUNT = 3;

	private int strikeCount = 0;
	private int ballCount = 0;
	private Balls randomBallNumbers;
	private Balls userBallNumbers;

	public BaseBallGameResult(Balls randomBallNumbers, Balls userBallNumbers) {
		this.randomBallNumbers = randomBallNumbers;
		this.userBallNumbers = userBallNumbers;
		calculateResult();
	}

	private void calculateResult() {
		for (int i = 0; i < randomBallNumbers.getBalls().size(); i++) {
			Ball ball = userBallNumbers.getBalls().get(i);
			plusBallCount(ball);
		}
	}

	private void plusBallCount(Ball ball) {
		if (randomBallNumbers.play(ball).isStrike()) {
			strikeCount++;
		}

		if (randomBallNumbers.play(ball).isBall()) {
			ballCount++;
		}
	}

	public boolean isAnswer() {
		return strikeCount == ANSWER_COUNT;
	}

	public boolean isNothing() {
		return strikeCount == 0 && ballCount == 0;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}
}
