package domain.target;

import java.util.Objects;

public class Ball {
	public static final int MAX_NUMBER_OF_BALL = 9;
	public static final int MIN_NUMBER_OF_BALL = 1;
	private int number;

	public Ball(int number) {
		validate(number);
		this.number = number;
	}

	private void validate(int number) {
		if (number > MAX_NUMBER_OF_BALL || number < MIN_NUMBER_OF_BALL) {
			throw new IllegalArgumentException("숫자는" + MIN_NUMBER_OF_BALL + "~" + MAX_NUMBER_OF_BALL + "사이 입니다.");
		}
	}

	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Ball)) return false;
		Ball ball = (Ball) o;
		return number == ball.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
