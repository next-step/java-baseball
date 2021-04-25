package baseball.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class BallNumber {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

    private final int number;

    public BallNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public BallNumber(String number) {
        this(parseInt(number));
    }

    private void validateNumber(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("숫자값은 1보다 작거나 9보다 클 수 없습니다.");
        }
    }

    private static int parseInt(String number) {
        validateStringNumber(number);
        return Integer.parseInt(number);
    }

    private static void validateStringNumber(String number) {
        if (!isNumber(number)) {
            throw new IllegalArgumentException("숫자 형태만 입력 가능합니다.");
        }
    }

    private static boolean isNumber(String number) {
        return NUMBER_PATTERN.matcher(number).find();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
