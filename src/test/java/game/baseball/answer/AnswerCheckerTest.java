package game.baseball.answer;

import game.baseball.vo.Answer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static game.baseball.constant.BaseballConfig.*;

class AnswerCheckerTest {

    @Test
    @DisplayName("Check Answer - Success")
    void checkAnswerSuccess() {
        List<Integer> correctList = new ArrayList<>();

        for (int i = 0; i < ANSWER_COUNT; i++) {
            correctList.add(ANSWER_NUMBER_MIN + i);
        }

        assertTrue(AnswerChecker.checkAnswer(new Answer(correctList), correctList));
    }

    @Test
    @DisplayName("Check Answer - Fail(More Element)")
    void checkAnswerFailMoreElement() {
        List<Integer> correctList = new ArrayList<>();

        for (int i = 0; i < ANSWER_COUNT; i++) {
            correctList.add(ANSWER_NUMBER_MIN + i);
        }

        List<Integer> illegalList = new ArrayList<>();
        for (int i = 0; i < ANSWER_COUNT + 1; i++) {
            illegalList.add(ANSWER_NUMBER_MIN + i);
        }

        assertFalse(AnswerChecker.checkAnswer(new Answer(correctList), illegalList));
    }

    @Test
    @DisplayName("Check Answer - Fail(Wrong Input)")
    void checkAnswerFailWrongInput() {
        List<Integer> correctList = new ArrayList<>();

        for (int i = 0; i < ANSWER_COUNT; i++) {
            correctList.add(ANSWER_NUMBER_MIN + i);
        }

        List<Integer> illegalList = new ArrayList<>();
        for (int i = 0; i < ANSWER_COUNT; i++) {
            illegalList.add(1);
        }

        assertFalse(AnswerChecker.checkAnswer(new Answer(correctList), illegalList));
    }
}