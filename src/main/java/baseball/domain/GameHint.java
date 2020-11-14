package baseball.domain;

public class GameHint {
	private int strikeCount = 0;
	private int ballCount = 0;

	public GameHint(GameNumbers rightAnswer, GameNumbers input) {
		countStrike(rightAnswer, input);
		countBall(rightAnswer, input);
	}

	private void countBall(GameNumbers rightAnswer, GameNumbers input) {
		ballCount = rightAnswer.countBall(input) - strikeCount;
	}

	public void countStrike(GameNumbers rightAnswer, GameNumbers userAnswer) {
		strikeCount = rightAnswer.countStrike(userAnswer);
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
