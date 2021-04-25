package com.baseball.precourse.baseball;

import java.util.StringJoiner;

public class Score {
    private int ball;
    private int strike;

    public Score(int strike, int ball){
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isOut(){
        return (strike == Ball.BALL_COUNT);
    }

    public String toString(){
        if (nothing()){
            return displayNothing();
        }
        return displayScore();
    }

    private boolean nothing(){
        return (strike == 0 && ball == 0);
    }

    private String displayScore(){
        StringJoiner joiner = new StringJoiner(" ");
        if (strike > 0){
            joiner.add(String.format("%d 스트라이크", strike));
        }
        if (ball > 0){
            joiner.add(String.format("%d 볼", ball));
        }

        return joiner.toString();
    }

    private String displayNothing(){
        return String.format("낫싱");
    }
}
