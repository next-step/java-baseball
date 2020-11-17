package domain;

public class Ball {

    private static final int NO_MATCHING = 0;

    private int ballCount;

    public Ball(int ball) {
        this.ballCount = ball;
    }

    public boolean isNoMatching() {
        return ballCount == NO_MATCHING;
    }

    public boolean isExistMatching() {
        return ballCount > NO_MATCHING;
    }

    public int getBallCount() {
        return ballCount;
    }

}
