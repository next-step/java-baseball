package domain;

public class Score {
    private int strike;
    private int ball;

    public Score() {
    }

    public void addStrike() {
        strike += 1;
    }

    public void addBall() {
        ball += 1;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isAllStrike() {
        return strike == 3;
    }

    public void printScore() {
        StringBuilder stringBuilder = new StringBuilder();
        if (isNothing()) {
            stringBuilder.append("낫싱");
        }
        appendScore(strike, " 스트라이크 ", stringBuilder);
        appendScore(ball, " 볼 ", stringBuilder);
        System.out.println(stringBuilder.toString());
    }

    private void appendScore(int score, String message, StringBuilder stringBuilder) {
        if (score != 0) {
            stringBuilder.append(score);
            stringBuilder.append(message);
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
