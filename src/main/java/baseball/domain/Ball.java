package baseball.domain;

import java.util.Objects;

public class Ball {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    private final int number;

    public Ball(int number) {
        this.number = number;
    }

    public static Ball of(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new NoAllowNumber("숫자는 1~9 사이어야 합니다.");
        }
        return new Ball(number);
    }

    public static Ball of(OneDigitNumber oneDigitNumber) {
        return of(oneDigitNumber.value());
    }

    public static Ball of(String number) {
        return of(Integer.parseInt(number));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball)) {
            return false;
        }
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
