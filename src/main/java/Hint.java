public class Hint {

    private static final int MAX_COUNT_OF_STRIKE = 3;

    private final int strike;
    private final int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isVictory() {
        return strike == MAX_COUNT_OF_STRIKE;
    }

    @Override
    public String toString() {

        if (strike == 0 && ball == 0) {
            return "nothing";
        }

        StringBuilder stringBuilder = new StringBuilder();

        if (strike > 0) {
            stringBuilder.append(strike)
                         .append(" strike ");
        }

        if (ball > 0) {
            stringBuilder.append(ball)
                         .append(" ball");
        }

        return stringBuilder.toString();
    }
}
