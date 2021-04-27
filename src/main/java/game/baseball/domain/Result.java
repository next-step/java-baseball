package game.baseball.domain;

public class Result {
    private int strike = 0;
    private int ball = 0;
    private boolean out = false;
    private boolean nothing = false;

    public int getStrikeCount() {
        return strike;
    }

    public int getBallCount() {
        return ball;
    }

    public void increaseStrike() {
        strike++;
    }

    public void increaseBall() {
        ball++;
    }

    public boolean isNothing() {
        return nothing;
    }

    public boolean isOut() {
        return out;
    }

    public void setOut() {
        this.out = true;
    }

    public void setNothing() {
        this.nothing = true;
    }
}
