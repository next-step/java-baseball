package com.ssabae.woowahantech.domain;

import com.ssabae.woowahantech.Constant;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-15
 */
public class GameScore {

    private int strike;
    private int ball;

    public GameScore() {
        this.strike = 0;
        this.ball = 0;
    }

    public void addStrike() {
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

    public boolean isCorrect() {
        return this.strike == Constant.GAME_NUMBER_SIZE;
    }

    public void print() {
        if (this.strike == 0 && this.ball == 0) {
            System.out.println("낫싱");
            return;
        }
        StringBuilder sb = new StringBuilder();
        printStrikeAndBall(sb);
        System.out.println(sb.toString());
    }

    private void printStrikeAndBall(StringBuilder sb) {
        if (this.strike != 0) {
            sb.append(String.format("%d %s ", this.strike, "스트라이크"));
        }
        if (this.ball != 0) {
            sb.append(String.format("%d %s ", this.ball, "볼"));
        }
        if (isCorrect()) {
            sb.append("\n3개의 숫자를 모두 맞히셨습니다! 게임종료");
        }
    }
}
