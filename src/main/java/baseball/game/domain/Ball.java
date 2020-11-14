package baseball.game.domain;

import baseball.game.exception.BallNumberRangeException;
import java.util.Objects;

public class Ball {
    public static final Integer MIN_NUMBER = 1;
    public static final Integer MAX_NUMBER = 9;

    private final Integer number;

    public Ball(Integer number) {
        validateNumber(number);

        this.number = number;
    }

    public static Ball of(Integer number) {
        return new Ball(number);
    }

    private void validateNumber(Integer number) {
        if(number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new BallNumberRangeException("");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return Objects.equals(number, ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
