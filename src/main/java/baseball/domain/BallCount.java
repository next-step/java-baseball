package baseball.domain;

public class BallCount {
    private int strike;
    private int ball;

    public boolean isNothing() {
        return (strike == 0 && ball == 0);
    }

    public void addStrike() {
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

    public boolean isAllStrike() {
        return (strike == 3);
    }

    public String getCurrent() {
        String result = "";

        if (isNothing()) { return "낫싱"; }

        if (strike != 0) { result += strike  + " 스트라이크 "; }

        if (ball != 0) { result += ball + " 볼"; }

        return result;
    }

    public void clear() {
        strike = 0;
        ball = 0;
    }

    @Override
    public String toString() {
        return "BallCount [strike=" + strike + ", ball=" + ball + "]";
    }

}
