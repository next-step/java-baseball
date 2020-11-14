package component;

import model.PatternResult;

public class AnswerChecker {
    private AnswerChecker() {
    }

    public static boolean isPatternForAnswer(PatternResult patternResult) {
        if (patternResult.getBallCount() != 0) {
            return false;
        }

        return patternResult.getStrikeCount() == 3;
    }
}
