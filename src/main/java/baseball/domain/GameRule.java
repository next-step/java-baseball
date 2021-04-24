package baseball.domain;

public enum GameRule {
    STRIKE,
    BALL,
    MISSING;

    public static GameRule of(Position ballPosition, Position destBallPosition) {
        if(ballPosition.equals(destBallPosition)) {
            return STRIKE;
        }else if (destBallPosition.equals(Position.NOT_FOUND)) {
            return MISSING;
        }

        return null;
    }
}
