package kr.aterilio.nextstep.techcamp.baseball;

public class BaseballResult {

	private int countStrike = 0;
	private int countBall = 0;

	private boolean existResult = true;

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

	public void nothing() {
		existResult = false;
	}

	public boolean hasResult() {
		return existResult;
	}
}
