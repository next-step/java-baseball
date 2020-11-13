package baseball.domain;

import java.util.Objects;

import static baseball.domain.State.*;

public class BaseballNumber {
    public static final int MIN_INDEX = 1;
    public static final int MAX_INDEX = 3;
    private final int index;
    private final Number number;

    public static BaseballNumber of(final int index, final int number) {
        return new BaseballNumber(index, new Number(number));
    }

    public BaseballNumber(final int index, final Number number) {
        if (index < MIN_INDEX || index > MAX_INDEX) {
            throw new IllegalArgumentException(String.format("index 범위는 %d와 %d 사이 입니다.", MIN_INDEX, MAX_INDEX));
        }
        this.index = index;
        this.number = number;
    }

    public State match(final BaseballNumber other) {
        if (index == other.index && number.equals(other.number)) {
            return STRIKE;
        }

        if (number.equals(other.number)) {
            return BALL;
        }

        return NOTING;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseballNumber)) return false;
        final BaseballNumber that = (BaseballNumber) o;
        return index == that.index &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, number);
    }
}
