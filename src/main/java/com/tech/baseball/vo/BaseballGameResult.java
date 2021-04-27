package com.tech.baseball.vo;

public class BaseballGameResult {

    private int strike;
    private int ball;

    public BaseballGameResult(){
        super();
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

    @Override
    public String toString() {
        String sb = strike +
                " 스트라이크 " +
                ball +
                "볼";
        return sb;
    }

}
