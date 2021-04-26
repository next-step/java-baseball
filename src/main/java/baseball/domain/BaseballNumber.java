package baseball.domain;

import baseball.constants.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseballNumber {
    private static final String INVALID_NUMBER_MESSAGE = String.format("%d부터 %d까지의 숫자만 입력 가능합니다.",
            Constants.BASEBALL_NUMBER_MIN_BOUND, Constants.BASEBALL_NUMBER_MAX_BOUND);
    private static final Map<Integer, BaseballNumber> baseballNumbers = new HashMap<>();

    private final int number;

    static {
        for (int i = Constants.BASEBALL_NUMBER_MIN_BOUND; i <= Constants.BASEBALL_NUMBER_MAX_BOUND; i++) {
            baseballNumbers.put(i, new BaseballNumber(i));
        }
    }

    private BaseballNumber(final int number) {
        this.number = number;
    }

    public static BaseballNumber from(final int number) {
        BaseballNumber baseballNumber = baseballNumbers.get(number);
        if (baseballNumber == null) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
        return new BaseballNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
