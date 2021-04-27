package engine;

import exception.BaseballException1;

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

	public boolean progressEachStage(Ball inputBall) throws BaseballException1 {
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
