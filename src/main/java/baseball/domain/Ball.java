package baseball.domain;

import baseball.domain.exception.NoAllowNumberException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ball {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final List<Ball> baseBalls = IntStream.range(1, 10)
        .mapToObj(Ball::new)
        .collect(Collectors.toList());

    private final int number;

    private Ball(int number) {
        this.number = number;
    }

    public static Ball of(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new NoAllowNumberException("숫자는 " + MIN_NUMBER + "~" + MAX_NUMBER + " 사이어야 합니다.");
        }
        return makeBall(number);
    }

    private static Ball makeBall(int number) {
        return baseBalls.get(number - 1);
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
