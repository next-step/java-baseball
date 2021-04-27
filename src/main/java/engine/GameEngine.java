package engine;

import exception.BaseballException1;

public class GameEngine {
	private int strike;
	private int ball;
	private int answerLength;
	private Ball1 answer;

	public GameEngine(int answerLength) {
		this.strike = 0;
		this.ball = 0;
		this.answerLength = answerLength;
		this.answer = new Ball1(answerLength);
	}

	public boolean progressEachStage(Ball1 inputBall) throws BaseballException1 {
		compareInputWithAnswer(inputBall);
		if (strike == 3) {
			return true;
		}
		return false;
	}

	public void resetGame() {
		this.answer = new Ball1(answerLength);
		System.out.println(answer);
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

	private void compareInputWithAnswer(Ball1 inputBall) {
		calculateStrike(inputBall);
		calculateBall(inputBall);
	}

	private void calculateStrike(Ball1 inputBall) {
		strike = answer.getStrike(inputBall);
	}

	private void calculateBall(Ball1 inputBall) {
		ball = answer.getBall(inputBall);
	}

}
