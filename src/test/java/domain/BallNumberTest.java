package domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import game.domain.BallNumber;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BallNumberTest {

    @DisplayName("ball 숫자를 잘 검증하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideBallNumberTest")
    void ballNumberTest(BallNumber ballNumber, BallNumber expected) {
        assertEquals(ballNumber, expected);
    }

    private static Stream<Arguments> provideBallNumberTest() {
        return Stream.of(
            Arguments.of(
                new BallNumber("1"), new BallNumber(1)
            ),
            Arguments.of(
                new BallNumber("9"), new BallNumber(9)
            )
        );
    }

    @DisplayName("잘못된 ball 숫자에 예외 던지는지 테스트")
    @ParameterizedTest
    @MethodSource("provideBallNumberFailTest")
    void ballNumberFailTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new BallNumber(input));
    }

    private static Stream<Arguments> provideBallNumberFailTest() {
        return Stream.of(
            Arguments.of(
                "10"
            ),
            Arguments.of(
                "dgdsgadgsd"
            ),
            Arguments.of(
                "@#@!"
            )
        );
    }
}
