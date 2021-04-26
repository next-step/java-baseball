package baseball.domain;

import java.util.Objects;

public class BallCount {
	private final int strike;
	private final int ball;

	public BallCount(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BallCount ballCount = (BallCount) o;
		return strike == ballCount.strike && ball == ballCount.ball;
	}

	@Override
	public int hashCode() {
		return Objects.hash(strike, ball);
	}

	@Override
	public String toString() {
		return "BallCount{" +
				"strike=" + strike +
				", ball=" + ball +
				'}';
	}
}
