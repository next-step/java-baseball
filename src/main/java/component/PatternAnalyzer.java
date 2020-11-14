package component;

import model.PatternResult;
import model.ThreeDigits;

public class PatternAnalyzer {
    private PatternAnalyzer() {}

    public static PatternResult analyze(ThreeDigits actual, ThreeDigits answer) {
        int strikeCount = getStrikeCount(actual, answer);
        int ballCount = getBallCount(actual, answer);

        return new PatternResult(strikeCount, ballCount);
    }

    private static int getStrikeCount(ThreeDigits actual, ThreeDigits answer) {
        int strikeCount = 0;

        for (int index = 0; index < 3; index++) {
            int actualDigit = actual.getDigitAt(index);
            int answerDigit = answer.getDigitAt(index);

            if (actualDigit == answerDigit) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private static int getBallCount(ThreeDigits actual, ThreeDigits answer) {
        int ballCount = 0;

        for (int index = 0; index < 3; index++) {
            int actualDigit = actual.getDigitAt(index);
            int answerDigit = answer.getDigitAt(index);

            if (actualDigit != answerDigit && answer.contains(actualDigit)) {
                ballCount++;
            }
        }

        return ballCount;
    }
}
