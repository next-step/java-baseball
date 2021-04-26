package baseball;

public class Score {

    private int strike;
    private int ball;

    public void init() {
        this.strike=0;
        this.ball=0;
    }

    public int getStrike() {
        return strike;
    }

    public void addStrike() {
        this.strike++;
    }

    public int getBall() {
        return ball;
    }

    public void addBall() {
        this.ball++;
    }

}
