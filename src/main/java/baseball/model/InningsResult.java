package baseball.model;

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

    @Override
    public String toString() {
        StringBuilder resultBuffer = new StringBuilder();
        if (ball != 0) {
            resultBuffer.append(ball).append("볼").append(" ");
        }
        if (strike != 0) {
            resultBuffer.append(strike).append("스트라이크").append(" ");
        }
        if (out == 3) {
            resultBuffer.append("낫싱");
        } else if (out != 0) {
            resultBuffer.append(out).append("아웃");
        }
        return resultBuffer.toString();
    }
}
