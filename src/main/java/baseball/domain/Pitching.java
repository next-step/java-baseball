package baseball.domain;

public enum Pitching {
    STRIKE,
    BALL,
    MISSING;

    public static Pitching of(Position ballPosition, Position destBallPosition) {
        if (ballPosition.equals(destBallPosition)) {
            return STRIKE;
        } else if (destBallPosition.equals(Position.NOT_FOUND)) {
            return MISSING;
        }

        return BALL;
    }
}
