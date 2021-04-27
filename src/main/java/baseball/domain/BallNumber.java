package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BallNumber {
    public static final int MAXIMUM_BALL_NUMBER = 9;
    public static final int MINIMUM_BALL_NUMBER = 1;
    public static final String BALL_VALID_RANGE = "공은 1과 9사이의 숫자만 가능합니다.";
    public static final String INPUT_ERROR = "숫자를 3개 입력해야합니다.";
    private final int number;

    public BallNumber(int number) {
        this.number = validate(number);
    }

    private int validate(int number) {
        if (number < MINIMUM_BALL_NUMBER || number > MAXIMUM_BALL_NUMBER) {
            throw new IllegalArgumentException(BALL_VALID_RANGE);
        }
        return number;
    }

    public int getNumber() {
        return number;
    }

    public static List<BallNumber> convertBallNumber(String value) {
        List<BallNumber> ballNumbers = new ArrayList<>();
        char[] numbers = value.toCharArray();
        if (numbers.length != 3) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
        for (char number : numbers) {
            ballNumbers.add(new BallNumber(number - '0'));
        }
        return new ArrayList<>(ballNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BallNumber)) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
