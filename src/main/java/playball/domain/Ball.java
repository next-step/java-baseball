package playball.domain;

import playball.exception.PlayBallIllegalArgumentException;

import java.util.Objects;

public class Ball {

    public final static Integer MIN_OF_BALL_NUMBER = 1;
    public final static Integer MAX_OF_BALL_NUMBER = 9;

    private final Integer ball;

    private Ball(Integer ball) {

        validate(ball);
        this.ball = ball;
    }

    public static Ball of(Integer ball) {
        return new Ball(ball);
    }

    private void validate(Integer ball) {
        if (isValidBallNumber(ball)) {
            throw new PlayBallIllegalArgumentException();
        }
    }

    private Boolean isValidBallNumber(Integer ball) {
        return !(ball >= MIN_OF_BALL_NUMBER && ball <= MAX_OF_BALL_NUMBER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball1 = (Ball) o;
        return Objects.equals(ball, ball1.ball);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball);
    }
}
