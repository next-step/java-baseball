package baseball.rule;

public class GameResult {

    private final int strikeCount;
    private final int ballCount;

    public GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isEndOfGame() {
        return strikeCount >= 3;
    }

    public int getBallCount() {
        return ballCount;
    }

    @Override
    public String toString() {
        if (strikeCount == 0 && ballCount == 0)
            return "낫씽";

        String resultMessage = "";
        if (strikeCount > 0)
            resultMessage += strikeCount + " 스트라이크 ";

        if(ballCount > 0)
            resultMessage += ballCount + " 볼 ";

        return resultMessage;
    }
}
