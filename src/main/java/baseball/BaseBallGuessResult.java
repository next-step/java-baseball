package baseball;

import static baseball.BaseBallRandomNumber.RANDOM_NUMBER_LENGTH;

public class BaseBallGuessResult {
    private int strike;
    private int ball;

    public boolean isCorrect() {
        return strike == RANDOM_NUMBER_LENGTH;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }
}
