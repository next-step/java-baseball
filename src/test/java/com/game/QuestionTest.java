package com.game;

import com.game.baseball.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuestionTest {

    private final int QUESTION_LENGTH = 3;

    @DisplayName("문제 생성")
    @Test
    void makeQuestionTest() {
        // Given
        Question question = new Question();

        // When
        Set<Integer> madeQuestion = question.make(QUESTION_LENGTH);
        System.out.println("madeQuestion = " + madeQuestion);

        // Then
        assertEquals(QUESTION_LENGTH, madeQuestion.size());
        for (Integer item : madeQuestion) {
            assertTrue(true, String.valueOf(1 <= item && item <= 9));
        }
    }

}
