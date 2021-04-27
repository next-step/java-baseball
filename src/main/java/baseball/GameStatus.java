package baseball;

import java.util.Objects;

public class GameStatus {
	private int strike;
	private int ball;

	public GameStatus() {

	}

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

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		GameStatus that = (GameStatus)object;
		return strike == that.strike && ball == that.ball;
	}

	@Override
	public int hashCode() {
		return Objects.hash(strike, ball);
	}
}
