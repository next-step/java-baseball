package com.leeha.baseball.controller.inspector;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.leeha.baseball.exception.InvalidAnswerException;

class BaseballGameInspectorTest {

    private static BaseballGameInspector inspector;
    private static List<Integer> balls;

    @BeforeAll
    static void initialize() {
        inspector = new BaseballGameInspector();
        balls = Arrays.asList(1, 2, 9);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void inspect_ShouldReturnFalseForIncorrectAnswer(String answer) {
        boolean inspect = inspector.inspect(balls, Arrays.asList(answer.split("")));

        assertThat(inspect)
            .isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "89", "99999"})
    void inspect_ShouldReturnInvalidAnswerExceptionForNotFillAnswer(String answer) {
        assertThrows(InvalidAnswerException.class, () -> inspector.inspect(balls, Arrays.asList(answer.split(""))));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void inspect_ShouldReturnInvalidAnswerExceptionForNullOrEmptyAnswer(List<String> numbers) {
        assertThrows(InvalidAnswerException.class, () -> inspector.inspect(balls, numbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"129"})
    void inspect_ShouldReturnTrueForCorrectAnswer(String answer) {
        boolean inspect = inspector.inspect(balls, Arrays.asList(answer.split("")));

        assertThat(inspect)
            .isTrue();
    }
}
