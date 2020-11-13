package baseball.domain;

import java.util.Objects;

public class Result {
    private final Ball ball;
    private final Strike strike;

    public Result(Ball ball, Strike strike){
        this.ball = Objects.requireNonNull(ball);
        this.strike = Objects.requireNonNull(strike);;
    }

    public Ball getBall() {
        return ball;
    }

    public Strike getStrike() {
        return strike;
    }
}
