package domain;

public class Number {
    private final int number;
    private final int position;

    private Number(int number, int position) {
        validationCheck(number);
        this.number = number;
        this.position = position;
    }

    public static Number of(int number, int position) {
        return new Number(number, position);
    }

    private void validationCheck(int number) {
        if (number > 9 || number < 1) {
            throw new IllegalArgumentException("숫자는 1 ~ 9 사이의 수여야 합니다.");
        }
    }
}
