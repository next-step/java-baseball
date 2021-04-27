package number;

import java.util.Objects;

public class Number {
	public static final int NUMBER_RADIX = 10;
	public static final int LOWER_BOUND = 1;
	public static final int UPPER_BOUND = 9;

	private final int number;

	private Number(int number) {
		checkRangeOfNumber(number);
		this.number = number;
	}

	private void checkRangeOfNumber(int number) {
		if (number < LOWER_BOUND || number > UPPER_BOUND) {
			throw IllegalNumberException.ILLEGAL_RANGE_OF_NUMBER;
		}
	}

	static Number of(int number) {
		return new Number(number);
	}

	static Number of(char number) {
		return new Number(Character.digit(number, NUMBER_RADIX));
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		Number otherNumber = (Number)other;
		return number == otherNumber.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
