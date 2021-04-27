package domain;

public class Score {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public static final String finalScore(int ball, int strike) {
        if(ball == 0 && strike == 0) {
            return NOTHING;
        }
        if(ball == 0) {
            return strike + " " + STRIKE;
        }
        if(strike == 0) {
            return ball + " " + BALL;
        }

        return ball + " " + BALL + " " + strike + " " + STRIKE;
    }

}

