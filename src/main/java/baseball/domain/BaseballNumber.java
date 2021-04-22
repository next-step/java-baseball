package baseball.domain;

public class BaseballNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int number;

    public BaseballNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("야구숫자는 " + MIN_NUMBER + " 과 " + MAX_NUMBER + " 사이의 수 이어야 합니다.");
        }
    }

    public boolean match(int number) {
        return this.number == number;
    }
}
