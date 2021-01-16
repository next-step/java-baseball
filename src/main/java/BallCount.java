import java.util.List;

public class BallCount {

    private final int ball;
    private final int strike;
    private final String ballCountMessage;

    private final String EMPTY_STRING = "";

    public BallCount(Numbers numbers1, Numbers numbers2) {
        List<Integer> answerNumbers = numbers1.getNumbers();
        List<Integer> anotherNumbers = numbers2.getNumbers();
        int balls = 0;
        int strikes = 0;
        int count = answerNumbers.size();
        for (int i = 0; i < count; i++) {
            if (answerNumbers.get(i).equals(anotherNumbers.get(i))) {
                strikes++;
            } else if (anotherNumbers.contains(answerNumbers.get(i))) {
                balls++;
            }
        }

        this.ball = balls;
        this.strike = strikes;
        this.ballCountMessage = createBallCountMessage(this.ball, this.strike);
    }

    private String createBallCountMessage(int ball, int strike) {
        if (isNoCount(ball, strike)) {
            return "낫싱";    // TODO: 볼카운트 관련 enum으로 분리?
        }
        String ballString = createBallString(ball);
        String strikeString = createStrikeString(strike);
        return (ballString + strikeString).trim();
    }

    private boolean isNoCount(int ball, int strike) {
        return strike == 0 && ball == 0;
    }

    private String createBallString(int ball) {
        if (ball <= 0) {
            return EMPTY_STRING;
        }
        return ball + "볼 ";
    }

    private String createStrikeString(int strike) {
        if (strike <= 0) {
            return EMPTY_STRING;
        }
        return strike + "스트라이크";
    }

    public void printCountMessages() {
        System.out.println(this.ballCountMessage);
    }

    public boolean isThreeStrikes() {
        return this.strike == 3;
    }
}
