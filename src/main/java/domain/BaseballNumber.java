package domain;

public enum BaseballNumber {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5),
    SIX(6), SEVEN(7), EIGHT(8), NINE(9);

    private final int value;

    BaseballNumber(int value) {
        this.value = value;
    }

    public static BaseballNumber of(int value) {
        BaseballNumber[] baseballNumbers = BaseballNumber.values();

        for (BaseballNumber baseballNumber : baseballNumbers) {
            if (baseballNumber.value == value) {
                return baseballNumber;
            }
        }

        return null;
    }
}
