package domain;

public class Hint {

    private static final int MAX_COUNT_OF_STRIKE = 3;
    private static final String BLANK = "";

    private final int strike;
    private final int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isNotVictory() {
        return strike != MAX_COUNT_OF_STRIKE;
    }

    @Override
    public String toString() {

        if (strike == 0 && ball == 0) {
            return "nothing";
        }

        return addStrikeString() + addBallString();
    }

    private String addStrikeString() {
        if (strike > 0) {
            return strike + " strike ";
        }
        return BLANK;
    }

    private String addBallString() {
        if (ball > 0) {
            return ball + " ball";
        }
        return BLANK;
    }
}
