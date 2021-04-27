package baseball.domain.score;

public class Normal implements Score {
    private static final String TEXT_STRIKE = "스트라이크 ";
    private static final String TEXT_BALL = "볼";
    private int strikeCount;
    private int ballCount;

    public Normal(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    @Override
    public String getResult() {
        StringBuilder sb = new StringBuilder();
        if (strikeCount > 0) {
            sb.append(strikeCount + TEXT_STRIKE);
        }
        if (ballCount > 0) {
            sb.append(ballCount + TEXT_BALL);
        }
        return sb.toString().trim();
    }
}
