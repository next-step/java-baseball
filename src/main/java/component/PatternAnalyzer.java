package component;

import model.PatternResult;
import model.ThreeDigits;

public class PatternAnalyzer {
    private final ThreeDigits actual;

    private final ThreeDigits answer;

    public PatternAnalyzer(ThreeDigits actual, ThreeDigits answer) {
        this.actual = actual;
        this.answer = answer;
    }

    public PatternResult analyze() {
        int strikeCount = getStrikeCount();
        int ballCount = getBallCount();

        return new PatternResult(strikeCount, ballCount);
    }

    private int getStrikeCount() {
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

    private int getBallCount() {
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
