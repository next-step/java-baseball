package com.yebgi83.baseball;

import com.yebgi83.baseball.model.PatternResult;
import com.yebgi83.baseball.model.ThreeDigits;

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
            } else if (answer.contains(actualDigit)) {
                ballCount++;
            }
        }

        return new PatternResult(strikeCount, ballCount);
    }
}
