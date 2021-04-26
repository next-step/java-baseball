package core;

import java.util.Objects;

/**
 * Description : 게임 내 정답 관련 class
 *
 * Created by jychoi on 2021/04/27.
 */
public class AnswerObject {

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AnswerObject that = (AnswerObject)o;
		return strike == that.strike && ball == that.ball && isFourBall == that.isFourBall;
	}

	@Override
	public int hashCode() {
		return Objects.hash(strike, ball, isFourBall);
	}

	public AnswerObject(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	// 스트라이크
	private int strike;
	// 볼
	private int ball;
	// 포볼 여부
	private boolean isFourBall = false;

	public int getStrike() {
		return strike;
	}

	public void setStrike(int strike) {
		this.strike = strike;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}

	public boolean isFourBall() {
		if (this.strike == 0 && this.ball == 0) {
			this.isFourBall = true;
		}
		return isFourBall;
	}
}

