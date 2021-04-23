package com.game;

import com.game.baseball.Answer;
import com.game.baseball.Result;
import com.game.baseball.Score;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreStrikeAndBallTest {

    private final int QUESTION_LENGTH = 3;
    private static HackingQuestion hackingQuestion;
    private static Score score;


    @BeforeAll
    static void constructQuestion() {
        hackingQuestion = new HackingQuestion();
        score = new Score(hackingQuestion);
    }

    @DisplayName("낫싱 테스트")
    @Test
    public void nothingTest() {
        // Given
        Set<Integer> hackedQuestionMap = makeHackedQuestionMap();
        hackingQuestion.make(QUESTION_LENGTH, hackedQuestionMap);

        // When
        Answer answer = makeAnswer(7, 8, 9);
        score.setAnswer(answer);
        Result result = score.calculate();

        // Then
        assertEquals(0, result.getStrike());
        assertEquals(0, result.getBall());
    }

    @DisplayName("스트라이크 1개 테스트")
    @Test
    public void countStrike1Test() {
        // Given
        Set<Integer> hackedQuestionMap = makeHackedQuestionMap();
        hackingQuestion.make(QUESTION_LENGTH, hackedQuestionMap);

        // When
        Answer answer = makeAnswer(1, 2, 3);
        score.setAnswer(answer);
        Result result = score.calculate();

        // Then
        assertEquals(1, result.getStrike());
        assertEquals(0, result.getBall());
    }

    @DisplayName("스트라이크 2개 테스트")
    @Test
    public void countStrike2Test() {
        // Given
        Set<Integer> hackedQuestionMap = makeHackedQuestionMap();
        hackingQuestion.make(QUESTION_LENGTH, hackedQuestionMap);

        // When
        Answer answer = makeAnswer(4, 9, 5);
        score.setAnswer(answer);
        Result result = score.calculate();

        // Then
        assertEquals(2, result.getStrike());
        assertEquals(0, result.getBall());
    }

    @DisplayName("스트라이크 3개 테스트")
    @Test
    public void countStrike3Test() {
        // Given
        Set<Integer> hackedQuestionMap = makeHackedQuestionMap();
        hackingQuestion.make(QUESTION_LENGTH, hackedQuestionMap);

        // When
        Answer answer = makeAnswer(4, 2, 5);
        score.setAnswer(answer);
        Result result = score.calculate();

        // Then
        assertEquals(3, result.getStrike());
        assertEquals(0, result.getBall());
    }

    @DisplayName("스트라이크 1개, 볼 1개 테스트")
    @Test
    public void countStrike1AndBall1Test() {
        // Given
        Set<Integer> hackedQuestionMap = makeHackedQuestionMap();
        hackingQuestion.make(QUESTION_LENGTH, hackedQuestionMap);

        // When
        Answer answer = makeAnswer(4, 5, 7);
        score.setAnswer(answer);
        Result result = score.calculate();

        // Then
        assertEquals(1, result.getStrike());
        assertEquals(1, result.getBall());
    }

    @DisplayName("스트라이크 1개, 볼 2개 테스트")
    @Test
    public void countStrike1AndBall2Test() {
        // Given
        Set<Integer> hackedQuestionMap = makeHackedQuestionMap();
        hackingQuestion.make(QUESTION_LENGTH, hackedQuestionMap);

        // When
        Answer answer = makeAnswer(4, 5, 2);
        score.setAnswer(answer);
        Result result = score.calculate();

        // Then
        assertEquals(1, result.getStrike());
        assertEquals(2, result.getBall());
    }

    @DisplayName("스트라이크 0개, 볼 1개 테스트")
    @Test
    public void countBall1Test() {
        // Given
        Set<Integer> hackedQuestionMap = makeHackedQuestionMap();
        hackingQuestion.make(QUESTION_LENGTH, hackedQuestionMap);

        // When
        Answer answer = makeAnswer(1, 3, 2);
        score.setAnswer(answer);
        Result result = score.calculate();

        // Then
        assertEquals(0, result.getStrike());
        assertEquals(1, result.getBall());
    }

    @DisplayName("스트라이크 0개, 볼 2개 테스트")
    @Test
    public void countBall2Test() {
        // Given
        Set<Integer> hackedQuestionMap = makeHackedQuestionMap();
        hackingQuestion.make(QUESTION_LENGTH, hackedQuestionMap);

        // When
        Answer answer = makeAnswer(1, 5, 2);
        score.setAnswer(answer);
        Result result = score.calculate();

        // Then
        assertEquals(0, result.getStrike());
        assertEquals(2, result.getBall());
    }

    @DisplayName("스트라이크 0개, 볼 3개 테스트")
    @Test
    public void countBall3Test() {
        // Given
        Set<Integer> hackedQuestionMap = makeHackedQuestionMap();
        hackingQuestion.make(QUESTION_LENGTH, hackedQuestionMap);

        // When
        Answer answer = makeAnswer(2, 5, 4);
        score.setAnswer(answer);
        Result result = score.calculate();

        // Then
        assertEquals(0, result.getStrike());
        assertEquals(3, result.getBall());
    }


    private Set<Integer> makeHackedQuestionMap() {
        Set<Integer> hackedQuestionMap = new LinkedHashSet<>();
        hackedQuestionMap.add(4);
        hackedQuestionMap.add(2);
        hackedQuestionMap.add(5);
        return hackedQuestionMap;
    }

    private Answer makeAnswer(int first, int second, int third) {
        Answer answer = new Answer();
        answer.add(first);
        answer.add(second);
        answer.add(third);
        return answer;
    }

}
