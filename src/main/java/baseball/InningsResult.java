package baseball;

public class InningsResult {
    private static final int END_MATCH_CONDITION = 3;
    private int out;
    private int strike;
    private int ball;

    public void addBallCount() {
        this.ball += 1;
    }

    public void addOutCount() {
        this.out += 1;
    }

    public void addStrikeCount() {
        this.strike += 1;
    }

    public boolean isEndMatch() {
        return strike == END_MATCH_CONDITION;
    }

    public int getStrike() {
        return strike;
    }

    @Override
    public String toString() {
        StringBuilder resultBuffer = new StringBuilder();
        if (ball != 0) {
            resultBuffer.append(ball).append("볼");
        }
        if (strike != 0) {
            resultBuffer.append(" ").append(strike).append("스트라이크");
        }
        if (out != 0) {
            resultBuffer.append(" ").append(out).append("아웃");
        }
        return resultBuffer.toString();
    }
}
