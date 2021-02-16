package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @DisplayName("입력된 문자열에 따라 숫자를 잘 생성하는지 확인한다")
    @ParameterizedTest
    @MethodSource("providerCreateByInputParams")
    void createByInput(String input, List<Integer> digits) {
        assertEquals(
            new Number(digits),
            Number.createByInput(input)
        );
    }

    private static Stream<Arguments> providerCreateByInputParams() {
        return Stream.of(
            Arguments.of("321", Arrays.asList(3, 2, 1)),
            Arguments.of("123", Arrays.asList(1, 2, 3))
        );
    }

    @DisplayName("입력된 문자열이 잘못된 경우 예외를 잘 던지는지 확인한다")
    @ParameterizedTest
    @MethodSource("providerCreateByWrongInputParams")
    void createByWrongInput(String wrongInput) {
        assertThrows(
            RuntimeException.class,
            () -> Number.createByInput(wrongInput)
        );
    }

    private static Stream<Arguments> providerCreateByWrongInputParams() {
        return Stream.of(
            Arguments.of("12"),
            Arguments.of("1234"),
            Arguments.of("ABC"),
            Arguments.of("012"),
            Arguments.of("112")
        );
    }

    @DisplayName("입력된 다른 숫자에 따른 스트라이크 개수를 잘 구하는지 확인한다")
    @ParameterizedTest
    @MethodSource("providerGetStrikeParams")
    void getStrike(List<Integer> candidateDigits, int strike) {
        Number answer = new Number(Arrays.asList(1, 2, 3));
        Number candidate = new Number(candidateDigits);

        assertEquals(
            strike,
            answer.getStrike(candidate)
        );
    }

    private static Stream<Arguments> providerGetStrikeParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3), 3),
            Arguments.of(Arrays.asList(1, 2, 4), 2),
            Arguments.of(Arrays.asList(1, 4, 5), 1),
            Arguments.of(Arrays.asList(4, 5, 6), 0)
        );
    }

    @DisplayName("입력된 다른 숫자에 따른 볼 개수를 잘 구하는지 확인한다")
    @ParameterizedTest
    @MethodSource("providerGetBallParams")
    void getBall(List<Integer> candidateDigits, int ball) {
        Number answer = new Number(Arrays.asList(1, 2, 3));
        Number candidate = new Number(candidateDigits);

        assertEquals(
            ball,
            answer.getBall(candidate)
        );
    }

    private static Stream<Arguments> providerGetBallParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(4, 5, 6), 0),
            Arguments.of(Arrays.asList(4, 1, 6), 1),
            Arguments.of(Arrays.asList(4, 1, 2), 2),
            Arguments.of(Arrays.asList(3, 1, 2), 3),
            Arguments.of(Arrays.asList(1, 3, 2), 2),
            Arguments.of(Arrays.asList(1, 3, 4), 1),
            Arguments.of(Arrays.asList(1, 2, 3), 0)
        );
    }
}