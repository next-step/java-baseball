package baseball.value;

public class Result {
    private int strike;
    private int ball;
    private boolean nothing;

    public Result() {
        strike = 0;
        ball = 0;
        nothing = false;
    }

    public void setResultEntry(int code) {
        if (code == Code.STRIKE) {
            addStrike();
            return;
        }

        if (code == Code.BALL) {
            addBall();
            return;
        }
    }

    public void addStrike() {
        strike++;
    }

    public int getStrike() {
        return strike;
    }

    public void addBall() {
        ball++;
    }

    public int getBall() {
        return ball;
    }

    public void setNothing() {
        nothing = true;
    }

    public boolean isNothing() {
        return nothing;
    }
}