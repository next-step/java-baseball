package baseball.domain;

public enum GameRule {
    STRIKE,
    BALL,
    MISSING;

    public static GameRule of(Position ballPosition, Position destBallPosition) {
        if(ballPosition.equals(destBallPosition)) {
            return STRIKE;
        }

        return null;
    }
}
