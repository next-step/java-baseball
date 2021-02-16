package model;

import java.util.ArrayList;

public class Player {
    private BaseBallNumbers baseBallNumbers;
    private int strike;
    private int ball;

    private Player(BaseBallNumbers baseBallNumbers) {
        this.baseBallNumbers = baseBallNumbers;
        strike = 0;
        ball = 0;
    }

    public BaseBallNumbers getBaseBallNumbers() {
        return baseBallNumbers;
    }

    public void setBaseBallNumbers(BaseBallNumbers baseBallNumbers) {
        this.baseBallNumbers = baseBallNumbers;
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

    public static Player of(BaseBallNumbers baseBallNumbers) {
        return new Player(baseBallNumbers);
    }
    public static Player of() {
        return new Player(BaseBallNumbers.of());
    }
}
