package baseballnumber;

import java.util.Objects;

import gamemaster.BaseballPoint;

public class BaseballNumberBoard {
	private int strike;
	private int ball;

	public BaseballNumberBoard(BaseballPoint baseballPoint) {
		if (baseballPoint.isBall()) {
			this.ball = 1;
		}

		if (baseballPoint.isStrike()) {
			this.strike = 1;
		}
	}

	public BaseballNumberBoard(int strike, int ball) {
		if (strike + ball > 3) {
			throw new IllegalArgumentException("스트라이크와 볼의 입력값을 다시 한번 확인해 주세요");
		}

		this.strike = strike;
		this.ball = ball;
	}

	public boolean isContinue() {
		return strike != 3;
	}

	public boolean isNothing() {
		return strike == 0 && ball == 0;
	}

	public void accumulate(BaseballNumberBoard input) {
		this.ball += input.ball;
		this.strike += input.strike;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof BaseballNumberBoard))
			return false;
		BaseballNumberBoard that = (BaseballNumberBoard)o;
		return strike == that.strike && ball == that.ball;
	}

	@Override
	public int hashCode() {
		return Objects.hash(strike, ball);
	}

}
