package com.leeha.baseball.controller.inspector;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.leeha.baseball.exception.InvalidAnswerException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballGameInspectorTest {

    private static BaseballGameInspector inspector;
    private static List<Integer> balls;

    @BeforeAll
    public static void initialize() {
        inspector = new BaseballGameInspector();
        balls = Arrays.asList(1, 2, 9);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void inspect_ShouldReturnFalse(String answer) {
        boolean inspect = inspector.inspect(balls, Arrays.asList(answer.split("")));

        assertThat(inspect)
            .isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "89", "99999"})
    void inspect_ShouldReturnInvalidAnswerException(String answer) {
        assertThrows(InvalidAnswerException.class, () -> inspector.inspect(balls, Arrays.asList(answer.split(""))));
    }

    @ParameterizedTest
    @ValueSource(strings = {"129"})
    void inspect_ShouldReturnTrue(String answer) {
        boolean inspect = inspector.inspect(balls, Arrays.asList(answer.split("")));

        assertThat(inspect)
            .isTrue();
    }
}
