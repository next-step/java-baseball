package game.baseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static game.baseball.domain.BaseBallMessage.NOT_ALLOWED_ZERO;

public class BaseBallNumber {

	public static final int MIN_OF_NUMBER = 1;
	public static final int MAX_OF_NUMBER = 9;

	private static final Map<Integer, BaseBallNumber> NUMBER_BY_BASEBALL;

	static {
		NUMBER_BY_BASEBALL = new HashMap<>();
		for (int i = MIN_OF_NUMBER; i <= MAX_OF_NUMBER; i++) {
			NUMBER_BY_BASEBALL.put(i, new BaseBallNumber(i));
		}
	}

	private final int number;

	public BaseBallNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public static BaseBallNumber of(int number) {
		checkArgument(number != 0, NOT_ALLOWED_ZERO);
		return NUMBER_BY_BASEBALL.get(number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BaseBallNumber that = (BaseBallNumber) o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
