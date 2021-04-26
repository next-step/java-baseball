package baseball;

public class Referee {

    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void addStrike() {
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

}
