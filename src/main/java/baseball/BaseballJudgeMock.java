package baseball;

import java.util.List;

public class BaseballJudgeMock implements BaseballJudge {

    private int resultCreatedCount;

    public BaseballJudgeMock() {
        resultCreatedCount = 0;
    }

    @Override
    public int getGameDigitCount() {
        return 0;
    }

    @Override
    public int calculateStrikeCount(List<String> input, List<String> answer) {
        return 0;
    }

    @Override
    public int calculateBallCount(List<String> input, List<String> answer) {
        return 0;
    }

    @Override
    public String createJudgementMessage(int strikeCount, int ballCount, int digits) {
        return null;
    }

    @Override
    public BaseballResult createBaseBallResult(List<String> rightAnswer, List<String> input) {
        if (resultCreatedCount > 2) {
            return new BaseballResult(0, 0, "success", true);
        }

        resultCreatedCount++;
        return new BaseballResult(0 ,0, "fail", false);
    }
}
