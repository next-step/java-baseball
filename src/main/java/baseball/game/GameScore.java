package baseball.game;

import static baseball.game.Game.*;

public class GameScore {

	private int strike = 0;
	private int ball = 0;

	public GameScore() {}

	public void strike() {
		validate();
		this.strike++;
	}

	public void ball() {
		validate();
		this.ball++;
	}

	public boolean isCleared() {
		return this.strike == BALL_COUNT;
	}

	public boolean hasStrike() {
		return this.strike > 0;
	}

	public boolean hasBall() {
		return this.ball > 0;
	}

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}

	private void validate() {
		if (isDone()) {
			throw new RuntimeException();
		}
	}

	private boolean isDone() {
		return (this.strike + this.ball) >= BALL_COUNT;
	}
}
