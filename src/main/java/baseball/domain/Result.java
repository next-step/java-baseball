package baseball.domain;

import java.util.Objects;

public class Result {
    private final int ball;
    private final int strike;

    public Result(int ball, int strike){
        this.ball = Objects.requireNonNull(ball);
        this.strike = Objects.requireNonNull(strike);;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
