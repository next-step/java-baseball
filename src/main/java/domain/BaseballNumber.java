package domain;

public class BaseballNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final Order order;
    private final int baseballNumber;

    public BaseballNumber(final Order order, final int baseballNumber) {
        validate(baseballNumber);
        this.order = order;
        this.baseballNumber = baseballNumber;
    }

    private void validate(final int baseballNumber) {
        if (MIN_NUMBER > baseballNumber || MAX_NUMBER < baseballNumber) {
            throw new IllegalArgumentException("숫자 범위를 초과하였습니다.");
        }
    }

    public Score compareNumber(final BaseballNumber otherBaseballNumber) {
        Order otherOrder = otherBaseballNumber.getOrder();
        int otherNumber = otherBaseballNumber.getBaseballNumber();

        if (order.isEqual(otherOrder) && baseballNumber == otherNumber) {
            return Score.STRIKE;
        }

        if (!order.isEqual(otherOrder) && baseballNumber == otherNumber) {
            return Score.BALL;
        }
        return Score.NOTHING;
    }

    public Order getOrder() {
        return order;
    }

    public int getBaseballNumber() {
        return baseballNumber;
    }
}
