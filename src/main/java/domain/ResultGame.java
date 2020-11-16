package domain;

public class Score {
    private int strike;
    private int ball;

    public Score() {
    }

    public void addStrike() {
        strike += 1;
    }

    public void addBall() {
        ball += 1;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isAllStrike() {
        return strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
