package camp.nextstep.edu.game;

public class BaseballGameResult {

    private final int strike;
    private final int ball;

    public BaseballGameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (strike > 0) stringBuilder.append(String.format("%d 스트라이크 ", strike));
        if (ball > 0) stringBuilder.append(String.format("%d 볼 ", ball));
        if (strike == 0 && ball == 0) stringBuilder.append("낫싱");

        return stringBuilder.toString();
    }
}
