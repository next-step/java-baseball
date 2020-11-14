package baseball.domain;

import java.util.Objects;
import java.util.StringJoiner;

import baseball.domain.exception.BaseballNumberRangeException;

public class BaseballNumber {

	private static final int START_RANGE = 0;
	private static final int END_RANGE = 9;
	private final int number;

	private BaseballNumber(int number) {
		this.number = number;
	}

	public static BaseballNumber valueOf(int number) {
		validateNumber(number);
		return new BaseballNumber(number);
	}

	private static void validateNumber(int number) {
		if (number < START_RANGE || number > END_RANGE) {
			throw new BaseballNumberRangeException();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BaseballNumber that = (BaseballNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", BaseballNumber.class.getSimpleName() + "[", "]")
			.add("number=" + number)
			.toString();
	}
}
