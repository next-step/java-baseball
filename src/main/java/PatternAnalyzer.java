import model.PatternResult;
import model.ThreeDigits;

public class PatternAnalyzer {
    private PatternAnalyzer() {
    }

    static public PatternResult analyze(ThreeDigits actual, ThreeDigits answer) {
        int strikeCount = 0, ballCount = 0;

        for (int index = 0; index < 3; index++) {
            int actualDigit = actual.getDigitAt(index);
            int answerDigit = answer.getDigitAt(index);

            if (actualDigit == answerDigit) {
                strikeCount++;
                continue;
            }

            if (answer.contains(actualDigit)) {
                ballCount++;
            }
        }

        return new PatternResult(strikeCount, ballCount);
    }
}
