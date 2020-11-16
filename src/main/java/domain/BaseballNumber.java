package domain;

public class BaseballNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final Order order;
    private final int baseballNumber;

    public BaseballNumber(Order order, final int baseballNumber) {
        validate(baseballNumber);

        this.order = order;
        this.baseballNumber = baseballNumber;
    }

    private void validate(final int baseballNumber) {
        if (MIN_NUMBER > baseballNumber || MAX_NUMBER < baseballNumber) {
            throw new IllegalArgumentException("숫자 범위를 초과하였습니다.");
        }
    }
}
