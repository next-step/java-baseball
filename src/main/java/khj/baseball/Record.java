package khj.baseball;

public class Record {
    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isComplete(int length) {
        return strike == length;
    }

    public void addStrike() {
        ++strike;
    }

    public void addBall() {
        ++ball;
    }
}
