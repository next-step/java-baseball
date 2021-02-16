package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @DisplayName("입력된 문자열에 따라 숫자를 잘 생성하는지 확인한다")
    @ParameterizedTest
    @MethodSource("providerCreateParams")
    void createByInput(String input, List<Integer> digits) {
        assertEquals(
            new Number(digits),
            Number.createByInput(input)
        );
    }

    private static Stream<Arguments> providerCreateParams() {
        return Stream.of(
            Arguments.of("321", Arrays.asList(3, 2, 1)),
            Arguments.of("123", Arrays.asList(1, 2, 3))
        );
    }
}