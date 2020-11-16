package domain;

public class Order {
    private static final int START_POSITION = 0;
    private static final int LAST_POSITION = 2;
    private final int value;

    public Order(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (START_POSITION > value || LAST_POSITION < value) {
            throw new IllegalArgumentException("자릿수 범위를 초과하였습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
