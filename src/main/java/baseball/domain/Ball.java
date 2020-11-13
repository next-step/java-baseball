package baseball.domain;


import java.util.Objects;

public class Ball {

    private final int ball;

    private Ball(int ball) {
        validateBall(ball);
        this.ball = ball;
    }

    public static Ball of(int ball) {
        return new Ball(ball);
    }

    private void validateBall(int ball) {
        if(ball < 0 || ball > 3){
            throw new IllegalArgumentException();
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
