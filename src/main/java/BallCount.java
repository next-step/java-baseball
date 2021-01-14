import java.util.List;

public class BallCount {

    private final int ball;
    private final int strike;
    private final String ballCountMessage;

    public BallCount(Numbers numbers1, Numbers numbers2) {
        int ball = 0;
        int strike = 0;
        List<Integer> answerNumbers = numbers1.getNumbers();
        List<Integer> anotherNumbers = numbers2.getNumbers();
        int count = answerNumbers.size();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (answerNumbers.get(i).equals(anotherNumbers.get(j))) {
                    if (i == j) strike++;
                    else ball++;
                    break;
                }
            }
        }

        this.ball = ball;
        this.strike = strike;
        if (strike == 0 && ball == 0) {
            this.ballCountMessage = "낫싱";
        } else {
            this.ballCountMessage = ball + "볼 " + strike + "스트라이크";
        }
    }

    public String getBallCountMessage() {
        return ballCountMessage;
    }
}
