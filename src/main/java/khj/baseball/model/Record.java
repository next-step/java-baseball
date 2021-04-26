package khj.baseball.model;

public class Record {
    private int strike = 0;
    private int ball = 0;

    public boolean isComplete(int length) {
        return strike == length;
    }

    public boolean isNoting() {
        return strike == 0 && ball == 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void addStrike() {
        ++strike;
    }

    public void addBall() {
        ++ball;
    }
}
