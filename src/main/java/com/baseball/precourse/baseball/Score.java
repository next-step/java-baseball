package com.baseball.precourse;

public class Score {
    private final int TOTAL_COUNT = 3;

    private int ball;
    private int strike;

    public void Score(int ball, int strike){
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isOut(){
        return (strike == TOTAL_COUNT);
    }

    public String toString(){
        StringBuffer buffer = new StringBuffer();
        if (strike > 0){
            buffer.append(String.format("%d 스트라이크", strike));
        }
        if (ball > 0){
            buffer.append(String.format("%d 볼", ball));
        }
        return buffer.toString();
    }


}
