package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class HintTest {

    static Stream<Arguments> provideThreeStrike() {
        return Stream.of(
                Arguments.of((Object) new Integer[] {1, 2, 3}, (Object) new Integer[] {1, 2, 3}),
                Arguments.of((Object) new Integer[] {4, 5, 6}, (Object) new Integer[] {4, 5, 6}),
                Arguments.of((Object) new Integer[] {9, 1, 2}, (Object) new Integer[] {9, 1, 2}));
    }

    @ParameterizedTest
    @MethodSource("provideThreeStrike")
    void validateThreeStrikeTest(Integer[] inputDigits1, Integer[] inputDigits2) {
        Number number1 = new Number(Arrays.asList(inputDigits1));
        Number number2 = new Number(Arrays.asList(inputDigits2));

        Hint hint = new Hint(number1, number2);
        assertThat(hint).isNotNull();

        assertThat(hint.getStrikeCount()).isEqualTo(3);
        assertThat(hint.getBallCount()).isEqualTo(0);
    }

    static Stream<Arguments> provideOneStrikeTwoBall() {
        return Stream.of(
                Arguments.of((Object) new Integer[] {1, 3, 2}, (Object) new Integer[] {1, 2, 3}),
                Arguments.of((Object) new Integer[] {6, 5, 4}, (Object) new Integer[] {4, 5, 6}),
                Arguments.of((Object) new Integer[] {9, 2, 1}, (Object) new Integer[] {9, 1, 2}));
    }

    @ParameterizedTest
    @MethodSource("provideOneStrikeTwoBall")
    void validateOneStrikeTwoBallTest(Integer[] inputDigits1, Integer[] inputDigits2) {
        Number number1 = new Number(Arrays.asList(inputDigits1));
        Number number2 = new Number(Arrays.asList(inputDigits2));

        Hint hint = new Hint(number1, number2);
        assertThat(hint).isNotNull();

        assertThat(hint.getStrikeCount()).isEqualTo(1);
        assertThat(hint.getBallCount()).isEqualTo(2);
    }

    static Stream<Arguments> provideThreeBall() {
        return Stream.of(
                Arguments.of((Object) new Integer[] {3, 1, 2}, (Object) new Integer[] {1, 2, 3}),
                Arguments.of((Object) new Integer[] {6, 4, 5}, (Object) new Integer[] {4, 5, 6}),
                Arguments.of((Object) new Integer[] {2, 9, 1}, (Object) new Integer[] {9, 1, 2}));
    }

    @ParameterizedTest
    @MethodSource("provideThreeBall")
    void validateThreeBallTest(Integer[] inputDigits1, Integer[] inputDigits2) {
        Number number1 = new Number(Arrays.asList(inputDigits1));
        Number number2 = new Number(Arrays.asList(inputDigits2));

        Hint hint = new Hint(number1, number2);
        assertThat(hint).isNotNull();

        assertThat(hint.getStrikeCount()).isEqualTo(0);
        assertThat(hint.getBallCount()).isEqualTo(3);
    }

    static Stream<Arguments> provideNothing() {
        return Stream.of(
                Arguments.of((Object) new Integer[] {3, 1, 2}, (Object) new Integer[] {4, 5, 6}),
                Arguments.of((Object) new Integer[] {6, 4, 5}, (Object) new Integer[] {7, 8, 9}),
                Arguments.of((Object) new Integer[] {2, 9, 1}, (Object) new Integer[] {3, 5, 7}));
    }

    @ParameterizedTest
    @MethodSource("provideNothing")
    void validateNothingTest(Integer[] inputDigits1, Integer[] inputDigits2) {
        Number number1 = new Number(Arrays.asList(inputDigits1));
        Number number2 = new Number(Arrays.asList(inputDigits2));

        Hint hint = new Hint(number1, number2);
        assertThat(hint).isNotNull();

        assertThat(hint.getStrikeCount()).isEqualTo(0);
        assertThat(hint.getBallCount()).isEqualTo(0);
    }
}
