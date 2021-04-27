package com.syl.game.baseball.domain.entity;

public class BaseBallJudgementStatus {
    private int strike;
    private int ball;
    private int nothing;

    public BaseBallJudgementStatus(int strike, int ball, int nothing) {
        this.strike = strike;
        this.ball = ball;
        this.nothing = nothing;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getNothing() {
        return nothing;
    }

    @Override
    public String toString() {
        if (nothing == 3) return "포볼";
        if (ball == 0) return strike + "스트라이크";
        return strike + "스트라이크 " + ball + "볼";
    }
}
