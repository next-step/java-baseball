import component.AnswerChecker;
import model.ThreeDigits;
import model.PatternResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class AnswerCheckerTest {
    @Test
    @DisplayName("3 스트라이크는 정답이어야 한다.")
    void checkIf_CaseOfThreeStrikesIsAnswer() {
        PatternResult patternResult = new PatternResult(3, 0);
        assertTrue(AnswerChecker.isPatternForAnswer(patternResult));
    }

    @Test
    @DisplayName("3 스트라이크 이외에의 다른 스트라이크는 정답이 아니어야 한다.")
    void checkIf_CaseOfAnyStrikesExceptForThreeStrikesIsNotBeAnswer() {
        for (int strikeCount = 0; strikeCount < 3; strikeCount++) {
            PatternResult patternResult = new PatternResult(3, 0);
            assertTrue(AnswerChecker.isPatternForAnswer(patternResult));
        }
    }

    @Test
    @DisplayName("볼이 있는 경우에는 정답이 아니어야 한다.")
    void checkIf_CaseOfAnyBallsIsNotBeAnswer() {
        boolean isFoundAnswer = false;

        for (int strikeCount = 0; !isFoundAnswer && strikeCount < 3; strikeCount++) {
            isFoundAnswer = isFoundAnswerByAnyBallCounts(strikeCount);
        }

        if (isFoundAnswer) {
            fail();
        }
    }

    boolean isFoundAnswerByAnyBallCounts(int strikeCount) {
        boolean isFound = false;

        int maxBallCount = ThreeDigits.COUNT_OF_DIGITS - strikeCount;

        for (int ballCount = 1; !isFound && ballCount <= maxBallCount; ballCount++) {
            PatternResult patternResult = new PatternResult(strikeCount, ballCount);
            isFound = AnswerChecker.isPatternForAnswer(patternResult);
        }

        return isFound;
    }
}
