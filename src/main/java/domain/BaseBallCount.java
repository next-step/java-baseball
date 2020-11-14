package domain;

import util.BaseBallCounter;

public class BaseBallCount implements BaseBallCounter {
    private int strike;
    private int ball;

    private BaseBallCount() {}

    public static BaseBallCount of(BaseBallNumbers c, BaseBallNumbers u) {
        return new BaseBallCount().count(c, u);
    }

    @Override
    public BaseBallCount count(BaseBallNumbers c, BaseBallNumbers u) {
        for(int i = 0; i < BaseBallNumbers.DEFAULT_MAX_SIZE; i++) {
            boolean isStrike = c.getBaseBallNumber(i).equals(u.getBaseBallNumber(i));
            boolean isBall = !isStrike && c.isMasked(u.getBaseBallNumber(i));
            this.count(isStrike, isBall);
        }
        return this;
    }

    public void count(boolean isStrike, boolean isBall) {
        if(isStrike) {
            addStrike();
            return;
        }
        if(isBall) addBall();
    }

    public boolean isThreeStrike() {
        return strike >= 3;
    }

    public void addStrike() {
        strike++;
    }

    public void addBall() {
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(strike == 0 && ball == 0) sb.append(BaseBallCountText.NOTHING.value());
        if(strike > 0) sb.append(strike).append(" ").append(BaseBallCountText.STRIKE.value()).append(" ");
        if(ball > 0) sb.append(ball).append(BaseBallCountText.BALL.value());
        return new String(sb).trim();
    }
}
