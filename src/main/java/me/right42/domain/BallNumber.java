package me.right42.domain;

import java.util.Objects;

public class BallNumber {

	private final int number;

	private static final int MAX_NUMBER = 9;

	private static final int MIN_NUMBER = 1;

	public BallNumber(int number) {
		validate(number);

		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	private void validate(int number) {
		if(number > MAX_NUMBER || number < MIN_NUMBER) {
			throw new IllegalArgumentException("볼의 사이즈는 1 이상 9 이하 입니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BallNumber that = (BallNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
