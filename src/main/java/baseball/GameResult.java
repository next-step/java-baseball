package baseball;

public class GameResult {

	private final int strike;
	private final int ball;

	public GameResult(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public boolean isFullStrike() {
		return strike == BaseballGameModel.NUMBER_SIZE;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
}
