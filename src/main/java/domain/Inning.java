package domain;

public class Inning {
    private final int tryNumber;
    private final int strike;
    private final int ball;

    public Inning (int tryNumber, int strike, int ball) {
        this.tryNumber = tryNumber;
        this.strike = strike;
        this.ball = ball;
    }

    public int getTryNumber() {
        return this.tryNumber;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }
}
