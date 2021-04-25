package basballgame.game;

import basballgame.ui.HintMessages;
import basballgame.ui.output.Output;

public class BaseballResult {
	private int strike;
	private int ball;

	public BaseballResult(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}

	public boolean onlyBall() {
		return this.ball > 0 && this.strike == 0;
	}

	public boolean onlyStrike() {
		return this.strike > 0 && this.ball == 0;
	}

	public boolean isNothing() {
		return this.strike == 0 && this.ball == 0;
	}
	
	public void print() {
		if (isNothing()) {
			Output.print(HintMessages.NOTHING_TEXT);
			return;
		}

		if (onlyStrike()) {
			Output.print(HintMessages.strikeMessage(getStrike()));
			return;
		}

		if (onlyBall()) {
			Output.print(HintMessages.ballMessage(getBall()));
			return;
		}

		Output.print(HintMessages.strikeAndBallMessage(getStrike(), getBall()));
	}

	public boolean isCorrectAnswer() {
		return this.getStrike() == 3;
	}
}
