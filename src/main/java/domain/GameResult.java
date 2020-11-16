package domain;

import static domain.BaseballMessage.*;

public class GameResult {
    private int strike;
    private int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String toString() {
        return toStrike().concat(toBall()).concat(toStrikeAndBall()).concat(toNothing());
    }

    private String toStrike() {
        if (strike != 0 && ball == 0) {
            return String.format(STRIKE, strike);
        }
        return "";
    }

    private String toBall() {
        if (strike == 0 && ball != 0) {
            return String.format(BALL, ball);
        }
        return "";
    }

    private String toStrikeAndBall() {
        if (strike != 0 && ball != 0) {
            return String.format(STRIKE_AND_BALL, strike, ball);
        }
        return "";
    }

    private String toNothing() {
        if (strike == 0 && ball == 0) {
            return NOTHING;
        }
        return "";
    }

    public boolean isStrikeOut() {
        return strike == 3 && ball == 0;
    }
}
