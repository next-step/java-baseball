package engine;

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
}
