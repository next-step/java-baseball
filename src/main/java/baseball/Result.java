package baseball;

public class Result {
    private static Result judge = new Result();
    private int strike;
    private int ball;

    private Result() {
        reset();
    }

    public static Result getInstance() {
        return judge;
    }

    private int getStrike() {
        return strike;
    }

    private int getBall() {
        return ball;
    }

    protected void addStrike() {
        strike += 1;
    }

    protected void addBall() {
        ball += 1;
    }

    private boolean hasStrike() {
        return strike > 0;
    }

    private boolean hasBall() {
        return ball > 0;
    }

    protected void reset() {
        strike = 0;
        ball = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (hasStrike())
            stringBuilder.append(String.format("%d 스트라이크 ", getStrike()));
        if (hasBall())
            stringBuilder.append(String.format("%d 볼 ", getBall()));
        if (!hasStrike() && !hasBall())
            stringBuilder.append("낫싱");

        reset();
        return stringBuilder.toString();
    }
}
