package model;

public class Score {
    private int strike;
    private int ball;

    public Score(){
        strike = 0;
        ball = 0;
    }

    public void setStrike(int count) {
        strike = count;
    }

    public void setBall(int count) {
        ball = count;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) {
            return "nothing";
        }
        if (strike == 0) {
            return ball + " ball";
        }
        if (ball == 0) {
            return strike + " strike";
        }
        return strike + " strike, " + ball + " ball";
    }
}
