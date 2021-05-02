package start.game;

public class Ball {
    private final int position;
    private final int ballNumber;

    public Ball(int position, int ballNumber) {
        this.position = position;
        this.ballNumber = ballNumber;
    }

    public BallStatus play(Ball ball) {
        if( this.equals(ball) ) {
            return BallStatus.STRIKE;
        }
        if( ball.matchNumber(ballNumber)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchNumber(int ballNumber) {
        return ballNumber == this.ballNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ball other = (Ball) obj;
        if (ballNumber != other.ballNumber)
            return false;
        if (position != other.position)
            return false;
        return true;
    }
    
}
