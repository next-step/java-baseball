package domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import game.domain.BallNumber;
import game.domain.RenewAnswer;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RenewAnswerTest {

    @DisplayName("answer를 잘 검증하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideRenewAnswerTest")
    void renewAnswerTest(RenewAnswer renewAnswer, RenewAnswer expected) {
        assertEquals(renewAnswer, expected);
    }

    private static Stream<Arguments> provideRenewAnswerTest() {
        return Stream.of(
            Arguments.of(
                new RenewAnswer("1"), new RenewAnswer(1)
            ),
            Arguments.of(
                new RenewAnswer("2"), new RenewAnswer(2)
            )
        );
    }

    @DisplayName("잘못된 answer에 예외 던지는지 테스트")
    @ParameterizedTest
    @MethodSource("provideRenewAnswerFailTest")
    void renewAnswerFailTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new RenewAnswer(input));
    }

    private static Stream<Arguments> provideRenewAnswerFailTest() {
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
