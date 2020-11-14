import component.AnswerChecker;
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
        for (int strikeCount = 0; strikeCount < 3; strikeCount++) {
            if (isFoundAnswerByAnyBallCounts(strikeCount)) {
                fail();
            }
        }
    }

    boolean isFoundAnswerByAnyBallCounts(int strikeCount) {
        for (int ballCount = 1; ballCount < 3 - strikeCount; ballCount++) {
            PatternResult patternResult = new PatternResult(strikeCount, ballCount);

            if (AnswerChecker.isPatternForAnswer(patternResult)) {
                return true;
            }
        }

        return false;
    }
}
