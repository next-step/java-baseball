package kr.aterilio.nextstep.techcamp.baseball;

public class BaseballResult {

	private int countStrike = 0;
	private int countBall = 0;

	private boolean failed = false;

	public void strike() {
		countStrike++;
	}

	public void ball() {
		countBall++;
	}

	public int getCountStrike() {
		return countStrike;
	}

	public int getCountBall() {
		return countBall;
	}

	public void failed() {
		failed = true;
	}

	public boolean isFailed() {
		return failed;
	}

	public boolean isGameOver() {
		return BaseballGame.GAME_SIZE == countStrike;
	}
}
