package domain.baseballNumber;

import domain.exceptions.OutOfBoundBaseballNumberException;

public enum BaseballNumber {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5),
    SIX(6), SEVEN(7), EIGHT(8), NINE(9);

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    private final int value;

    BaseballNumber(int value) {
        this.value = value;
        BaseballNumberCache.lookup.put(value, this);
    }

    public static BaseballNumber of(int value) {
        BaseballNumber baseballNumber = BaseballNumberCache.lookup.get(value);

        if (baseballNumber == null) {
            throw new OutOfBoundBaseballNumberException();
        }

        return baseballNumber;
    }

    public int countSameNumber(BaseballNumber compareTarget) {
        if (this.value == compareTarget.value) {
            return 1;
        }
        return 0;
    }
}
