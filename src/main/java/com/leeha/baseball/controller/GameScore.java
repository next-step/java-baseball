package com.leeha.baseball.controller;

public class GameScore {

    private int strike = 0;
    private int ball = 0;

    public void addStrike() {
        strike += 1;
    }

    public void addBall() {
        ball += 1;
    }

    public boolean isPerfectScore(int ballCunt) {
        return strike == ballCunt;
    }
}