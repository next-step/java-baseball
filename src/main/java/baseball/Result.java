package baseball;

public class Result {
    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void init() {
        this.strike = 0;
        this.ball = 0;
    }

    public String getResultMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(makeResultMessageForStrike());
        builder.append(makeResultMessageForBall());
        builder.append(makeResultMessageForNothing());
        return builder.toString();
    }

    private String makeResultMessageForStrike() {
        if (this.strike != 0) {
            return this.strike + "스트라이크";
        }
        return "";
    }

    private String makeResultMessageForBall() {
        if (this.ball != 0) {
            return this.ball + "볼";
        }
        return "";
    }

    private String makeResultMessageForNothing() {
        if (this.strike == 0 && this.ball == 0) {
            return "낫싱";
        }
        return "";
    }
}
