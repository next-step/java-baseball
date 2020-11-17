package com.leeha.baseball.controller;

public class BaseballGameScore {

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

    public void displayScore() {
        display(strike, "스트라이크");
        display(ball, "볼");

        if (strike == 0 && ball == 0) {
            System.out.println("볼넷");
        }
    }

    private void display(int score, String hint) {
        if (score > 0) {
            System.out.println(score + " " + hint + " ");
        }
    }
}
