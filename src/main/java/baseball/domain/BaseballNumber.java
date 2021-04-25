package baseball.domain;

import java.util.Objects;

public class BaseballNumber {

	private final int number;

	public BaseballNumber(int number) {
		validate(number);

		this.number = number;
	}

	private void validate(int number) {
		if (number < 1 || number > 9) {
			throw new IllegalArgumentException("숫자는 1 ~ 9까지 가능합니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BaseballNumber that = (BaseballNumber) o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

}
