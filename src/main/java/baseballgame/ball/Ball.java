package baseballgame.ball;

import baseballgame.constant.BallRange;

import java.util.Objects;

public class Ball {

    private int number;

    public int getNumber() {
        return number;
    }

    public static Ball createBall(int number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException();
        }
        Ball ball = new Ball();
        ball.number = number;
        return ball;
    }

    public static boolean isValid(int number) {
        if (BallRange.MIN_NUMBER <= number && number <= BallRange.MAX_NUMBER)
            return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}