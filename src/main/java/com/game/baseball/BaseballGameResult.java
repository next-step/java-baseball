package com.game.baseball;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseballGameResult {

    private final int strike;
    private final int ball;

    public BaseballGameResult() {
        this.strike = 0;
        this.ball = 0;
    }

    @Override
    public String toString() {
        if ((strike + ball) == 0)
            return ResultType.NOTHING.getMessage();

        if (strike == 0 && ball > 0)
            return String.format("%d %s", ball, ResultType.BALL.getMessage());

        if (strike > 0 && ball == 0)
            return String.format("%d %s", strike, ResultType.STRIKE.getMessage());

        return String.format("%d %s %d %s", strike, ResultType.STRIKE.getMessage(), ball, ResultType.BALL.getMessage());
    }
}
