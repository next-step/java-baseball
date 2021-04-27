package baseball.domain;

import java.util.List;
import java.util.Objects;

/**
 * 컴퓨터가 생성한 볼.
 */
public class Ball {
    private final BallNumbers ballNumbers;

    public Ball(BallNumbers ballNumbers) {
        this.ballNumbers = ballNumbers;
    }

    public List<BallNumber> getBallList() {
        return ballNumbers.getBallNumbers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return Objects.equals(ballNumbers, ball.ballNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumbers);
    }

    @Override
    public String toString() {
        return String.valueOf(ballNumbers);
    }
}
