package baseballgame.game;

public enum MatchResult {
    STRIKE,
    BALL,
    UNMATCHED,
    ;

    public static MatchResult of(boolean valueMatched, boolean positionMatched) {
        if (valueMatched && positionMatched) {
            return STRIKE;
        }
        if (valueMatched) {
            return BALL;
        }
        return UNMATCHED;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
