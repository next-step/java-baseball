public class Hint {
	private final int strike;
	private final int ball;

	public Hint(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public boolean is3Strike() {
		return strike == 3;
	}

	public boolean isNothing() {
		return ball == 0 && strike == 0;
	}

	public String getMessage() {
		if (is3Strike()) {
			return "3개의 숫자를 모두 맞히셨습니다! 게임종료";
		}
		if (isNothing()) {
			return "낫싱";
		}
		String message = strike > 0 ? strike + " 스트라이크 " : "";
		message += ball > 0 ? ball + " 볼" : "";
		return message;
	}
}
