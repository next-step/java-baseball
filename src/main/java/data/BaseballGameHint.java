package data;

import constant.BaseballGameCondition;

public class BaseballGameHint {
	private int strike;
	private int ball;

	public BaseballGameHint() {
		this.strike = 0;
		this.ball = 0;
	}

	public BaseballGameHint(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public void addStrike() {
		this.strike += 1;
	}

	public void addBall() {
		this.ball += 1;
	}

	public boolean isCorrect() {
		return this.strike == BaseballGameCondition.BALL_NUMBER_LENGTH;
	}

	public boolean isWrongAnswer() {
		return this.strike != BaseballGameCondition.BALL_NUMBER_LENGTH;
	}

	public String toHintString() {
		if(this.strike == 0 && this.ball == 0) {
			return "낫싱";
		}
		StringBuilder sb = new StringBuilder();
		if(strike > 0) {
			sb.append(strike);
			sb.append(" 스트라이크 ");
		}
		if(ball > 0) {
			sb.append(ball);
			sb.append(" 볼");
		}
		return sb.toString().trim();
	}
}
