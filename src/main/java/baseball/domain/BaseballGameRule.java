package baseball.domain;

public enum BaseballGameRule {

    MIN_NUMBER_OF_BASEBALL_NUMBER(1),
    MAX_NUMBER_OF_BASEBALL_NUMBER(9),
    COUNT_OF_BASEBALL_NUMBERS(3);

    private final int value;

    BaseballGameRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
