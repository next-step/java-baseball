package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnswerCheckerTest {

    private static final AnswerChecker CORRECT_ANSWER_CHECKER =
        new AnswerChecker(new Numbers(Arrays.asList(2, 5, 7)));

    @DisplayName("맞춘 숫자가 없는 경우 nothing 출력")
    @Test
    void test01() {

        String expected = "nothing";
        String actual = CORRECT_ANSWER_CHECKER.makeResultHint(new Numbers(Arrays.asList(1, 3, 4)))
                                              .toString();

        assertEquals(expected, actual);
    }

    @DisplayName("숫자만 맞추면 ball 출력")
    @MethodSource(value = "test02Params")
    @ParameterizedTest
    void test02(List<Integer> numbers, int countOfAnswer) {

        String expected = countOfAnswer + " ball";
        String actual = CORRECT_ANSWER_CHECKER.makeResultHint(new Numbers(numbers))
                                              .toString();

        assertEquals(expected, actual);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> test02Params() {
        return Stream.of(
            Arguments.of(Arrays.asList(5, 7, 2), 3),
            Arguments.of(Arrays.asList(5, 7, 1), 2),
            Arguments.of(Arrays.asList(5, 3, 1), 1)
        );
    }

    @DisplayName("숫자와 위치를 모두 맞추면 strike를 출력하고 3 strike인 경우 승리")
    @MethodSource(value = "test03Params")
    @ParameterizedTest
    void test03(List<Integer> numbers, int countOfAnswer) {

        Hint hint = CORRECT_ANSWER_CHECKER.makeResultHint(new Numbers(numbers));
        String expected = countOfAnswer + " strike ";
        String actual = hint.toString();

        assertEquals(expected, actual);

        if (countOfAnswer == 3) {
            assertFalse(hint.isNotVictory());
        } else {
            assertTrue(hint.isNotVictory());
        }
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> test03Params() {
        return Stream.of(
            Arguments.of(Arrays.asList(2, 5, 7), 3),
            Arguments.of(Arrays.asList(2, 5, 3), 2),
            Arguments.of(Arrays.asList(2, 4, 3), 1)
        );
    }

    @DisplayName("strike와 ball을 함께 출력하는 경우 strike, ball 순으로 나타난다.")
    @MethodSource(value = "test04Params")
    @ParameterizedTest
    void test04(List<Integer> numbers, int countOfStrike, int countOfBall) {

        Hint hint = CORRECT_ANSWER_CHECKER.makeResultHint(new Numbers(numbers));
        String expected = countOfStrike + " strike " + countOfBall + " ball";
        String actual = hint.toString();

        assertEquals(expected, actual);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> test04Params() {
        return Stream.of(
            Arguments.of(Arrays.asList(2, 7, 5), 1, 2),
            Arguments.of(Arrays.asList(2, 7, 3), 1, 1)
        );
    }
}