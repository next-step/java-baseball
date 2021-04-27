package baseball.domain;

public class Number {
    private int number;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public Number(int number) {
        checkRangeNumber(number);
        this.number = number;
    }

    public int number() {
        return this.number;
    }

    private void checkRangeNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER){
            throw new IllegalArgumentException("숫자범위는 0-9까지 입니다.");
        }
    }
}
