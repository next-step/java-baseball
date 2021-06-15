package domain;

public class Ball {
    BallNumber ballNumber;
    BallPosition ballPosition;

    public Ball(BallNumber ballNumber, BallPosition position) {
        this.ballNumber = ballNumber;
        ballPosition = position;
    }

    public int number() {
        return this.ballNumber.number();
    }

    public int position() {
        return this.ballPosition.position();
    }
}
