package domain;

import utils.UtilMeassage;

import java.util.Objects;

public class Ball {

    private static final int BALL_ZERO = 0;
    private static final int BALL_SIZE = 3;

    private final int ball;

    private Ball(int ball) {
        validateBall(ball);
        this.ball = ball;
    }

    public static Ball of(int ball) {
        return new Ball(ball);
    }

    private void validateBall(int ball) {
        if(ball < BALL_ZERO || ball > BALL_SIZE){
            throw new IllegalArgumentException(UtilMeassage.BALL_SIZE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball1 = (Ball) o;
        return ball == ball1.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball);
    }

    @Override
    public String toString() {
        return String.valueOf(ball);
    }

}
