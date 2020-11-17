package baseball;

import java.util.List;

public interface BaseballJudge {
    int getGameDigitCount();
    int calculateStrikeCount(List<String> input, List<String> answer);
    int calculateBallCount(List<String> input, List<String> answer);
    String createJudgementMessage(int strikeCount, int ballCount, int digits);

    default boolean isRightAnswer(int strikeCount) {
        return strikeCount == getGameDigitCount();
    }

    default BaseballResult createBaseBallResult(List<String> rightAnswer, List<String> input) {
        int strikeCount = calculateStrikeCount(rightAnswer, input);
        int ballCount = calculateBallCount(rightAnswer, input);
        String judgementMessage = createJudgementMessage(strikeCount, ballCount, getGameDigitCount());
        boolean isRightAnswer = isRightAnswer(strikeCount);
        return new BaseballResult(strikeCount, ballCount, judgementMessage, isRightAnswer);
    }
}
