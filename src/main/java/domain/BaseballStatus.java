package domain;

public class BaseballStatus {
    private final int strikeCount;
    private final int ballCount;
    private static final String STRIKE_MESSAGE = "%d스트라이크";
    private static final String BALL_MESSAGE = "%d볼";
    private static final String NOTHING_MESSAGE = "낫싱";


    public BaseballStatus(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        if (ballCount > 0) {
            string.append(String.format(BALL_MESSAGE, ballCount));
        }
        if (strikeCount > 0) {
            string.append(String.format(STRIKE_MESSAGE, strikeCount));
        }
        if (string.length() == 0){
            string.append(NOTHING_MESSAGE);
        }
        return string.toString();
    }
}
