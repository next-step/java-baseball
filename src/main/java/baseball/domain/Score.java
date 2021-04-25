package baseball.domain;

public class Score {
    private int strike;
    private int ball;

    public Score() {
        strike = 0;
        ball = 0;
    }

    public void addStrike(){
        strike++;
    }

    public void addBall(){
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
