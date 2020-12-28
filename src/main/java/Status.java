public class Status {
    private int strike;
    private int ball;
    private int nothing;

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getNothing() {
        return nothing;
    }

    public void setNothing(int nothing) {
        this.nothing = nothing;
    }

    @Override
    public String toString() {
        return "Status{" +
                "strike=" + strike +
                ", ball=" + ball +
                ", nothing=" + nothing +
                '}';
    }
}
