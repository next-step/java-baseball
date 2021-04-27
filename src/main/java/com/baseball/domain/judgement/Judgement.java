package com.baseball.domain.judgement;

public class Judgement {

    private final int strike;
    private final int ball;
    private boolean nothing;

    public Judgement(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
        setNothing();
    }

    private void setNothing() {
        if (strike == 0 && ball == 0) {
            this.nothing = true;
            return;
        }
        this.nothing = false;
    }

    public boolean isAllStrike() {
        return (strike == 3) ? true : false;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        return nothing;
    }
}
