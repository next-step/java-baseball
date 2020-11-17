package com.demo.baseball;

public class Decision {

    private int strike;

    private int ball;

    private int count;

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void addStrike() {
        this.strike++;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void addBall() {
        this.ball++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addCount() {
        this.count++;
    }

    @Override
    public String toString() {
        StringBuilder decision = new StringBuilder();
        if(this.getStrike() > 0) {
            decision.append(this.getStrike()).append(" 스트라이크 ");
        }
        if (this.getBall() > 0) {
            decision.append(this.getBall()).append(" 볼 ");
        }
        if(this.getCount() == 3 && this.getStrike() == 0 && this.getBall() == 0) {
            decision.append("NOTHING");
        }
        return decision.toString();
    }
}
