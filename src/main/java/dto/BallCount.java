package dto;

import java.util.Objects;

public class BallCount {
	private int strike = 0;
	private int ball = 0;

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public void addStrike() {
		strike++;
	}

	public void addBall() {
		ball++;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final BallCount ballCount = (BallCount)o;
		return this.getStrike() == ballCount.getStrike() && this.getBall() == ballCount.getBall();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getStrike(), getBall());
	}
}
