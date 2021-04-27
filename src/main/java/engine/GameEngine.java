package engine;

public class GameEngine {
	private int strike;
	private int ball;
	private int answerLength;
	private Ball answer;

	public GameEngine(int answerLength) {
		this.strike = 0;
		this.ball = 0;
		this.answerLength = answerLength;
		this.answer = new Ball(answerLength);
	}

	public GameEngine(String input, int answerLength) throws IllegalArgumentException {
		this.strike = 0;
		this.ball = 0;
		this.answerLength = answerLength;
		this.answer = new Ball(input, answerLength);
	}

	public Ball getAnswer() {
		return answer;
	}

	public boolean progressEachStage(Ball inputBall) throws IllegalArgumentException {
		resetStage();
		compareInputWithAnswer(inputBall);
		if (strike == 3) {
			return true;
		}
		return false;
	}

	public void resetGame() {
		this.answer = new Ball(answerLength);
	}

	private void resetStage() {
		this.strike = 0;
		this.ball = 0;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	private void compareInputWithAnswer(Ball inputBall) {
		calculateStrike(inputBall);
		calculateBall(inputBall);
	}

	private void calculateStrike(Ball inputBall) {
		strike = answer.getStrike(inputBall);
	}

	private void calculateBall(Ball inputBall) {
		ball = answer.getBall(inputBall);
	}

}
