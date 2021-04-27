package domain;

public class PitchingResult {
    int strike = 0;
    int ball = 0;
    boolean nothing = false;
    boolean result = false;

    public PitchingResult() {
    }

    public PitchingResult(int strike, int ball, boolean nothing, boolean result) {
        this.strike = strike;
        this.ball = ball;
        this.nothing = nothing;
        this.result = result;
    }

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

    public boolean isNothing() {
        return nothing;
    }

    public void setNothing(boolean nothing) {
        this.nothing = nothing;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
