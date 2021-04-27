package baseball.domain;

public class Result {
	public int ball;
	public int strike;

	public boolean isSuccess() {
		return strike == Game.NUMBER_LENGTH;
	}

	public boolean isNothing() {
		return ball == 0 && strike == 0;
	}
}
