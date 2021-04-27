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
        StringBuilder sb = new StringBuilder();
        sb.append(strike);
        sb.append(" 스트라이크 ");
        sb.append(ball);
        sb.append("볼");
        return sb.toString();
    }

}
