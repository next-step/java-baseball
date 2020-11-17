package baseball;

import java.util.List;

public class BaseballJudgeMock implements BaseballJudge {

    private final int digitCount;
    private final int strikeCount;
    private final int ballCount;
    private final String judgementMessage;

    public BaseballJudgeMock(int digitCount, int strikeCount, int ballCount, String judgementMessage) {
        this.digitCount = digitCount;
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.judgementMessage = judgementMessage;
    }

    @Override
    public int getGameDigitCount() {
        return digitCount;
    }

    @Override
    public int calculateStrikeCount(List<String> input, List<String> answer) {
        return strikeCount;
    }

    @Override
    public int calculateBallCount(List<String> input, List<String> answer) {
        return ballCount;
    }

    @Override
    public String createJudgementMessage(int strikeCount, int ballCount, int digits) {
        return judgementMessage;
    }
}
