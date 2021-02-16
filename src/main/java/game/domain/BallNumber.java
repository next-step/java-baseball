package game.domain;

import java.util.Objects;

public class BallNumber {
    private final int ballNumber;

    public BallNumber(String ball) throws IllegalArgumentException {
        validateBall(ball);
        ballNumber = Integer.parseInt(ball);
    }

    public BallNumber(int ballNumber) {
        this.ballNumber = ballNumber;
    }

    private void validateBall(String ball) throws IllegalArgumentException {
        if(Integer.parseInt(ball) <= 0 || Integer.parseInt(ball) > 9){
            throw new IllegalArgumentException();
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
        BallNumber that = (BallNumber) o;
        return Objects.equals(ballNumber, that.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }
}
