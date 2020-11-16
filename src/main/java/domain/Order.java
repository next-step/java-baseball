package domain;

public class Order {
    private static final int START_POSITION = 0;
    private static final int LAST_POSITION = 2;

    private final int value;

    public Order(final int value) {
        validate(value);
        this.value = value;
    }

    public boolean isEqual(final Order order) {
        return value == order.getValue();
    }

    private void validate(final int value) {
        if (START_POSITION > value || LAST_POSITION < value) {
            throw new IllegalArgumentException("자릿수 범위를 초과하였습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
