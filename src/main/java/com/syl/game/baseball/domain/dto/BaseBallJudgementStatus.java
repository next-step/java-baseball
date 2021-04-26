package com.syl.game.baseball.domain.dto;

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

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getNothing() {
        return nothing;
    }

    public void setNothing(int nothing) {
        this.nothing = nothing;
    }

    @Override
    public String toString() {
        if (nothing == 3) return "포볼";
        return strike + " 스트라이크" + ball + " 볼";
    }
}
