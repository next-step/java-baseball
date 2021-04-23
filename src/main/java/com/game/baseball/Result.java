package com.game.baseball;

public class Result {

    private Integer strike;
    private Integer ball;

    private Result() {
    }

    public Result(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
        System.out.println(this.toString());
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (strike > 0) {
            stringBuffer.append(strike.toString() + " 스트라이크 ");
        }
        if (ball > 0) {
            stringBuffer.append(ball.toString() + " 볼");
        }
        if (strike == 0 && ball == 0) {
            stringBuffer.append("낫싱");
        }
        return stringBuffer.toString();
    }
}
