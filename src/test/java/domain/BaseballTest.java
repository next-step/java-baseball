package domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import game.domain.BallNumber;
import game.domain.Baseball;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BaseballTest {

    @DisplayName("Baseball 숫자를 잘 검증하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideBaseballTest")
    void baseballTest(Baseball baseball, Baseball expected) {
        assertEquals(baseball, expected);
    }

    private static Stream<Arguments> provideBaseballTest() {
        return Stream.of(
            Arguments.of(
                new Baseball("123"),
                new Baseball(Arrays.asList(
                    new BallNumber(1),
                    new BallNumber(2),
                    new BallNumber(3)
                ))
            ),
            Arguments.of(
                new Baseball("456"),
                new Baseball(Arrays.asList(
                    new BallNumber(4),
                    new BallNumber(5),
                    new BallNumber(6)
                ))
            )
        );
    }

    @DisplayName("잘못된 Baseball 숫자에 예외 던지는지 테스트")
    @ParameterizedTest
    @MethodSource("provideBaseballFailTest")
    void renewAnswerFailTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Baseball(input));
    }

    private static Stream<Arguments> provideBaseballFailTest() {
        return Stream.of(
            Arguments.of(
                "111"
            ),
            Arguments.of(
                "1234"
            ),
            Arguments.of(
                "10"
            ),
            Arguments.of(
                "dsgsdgsdsd"
            )
        );
    }

    @DisplayName("strike 개수를 잘 계산하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideCalculateStrikeCountTest")
    void calculateStrikeCountTest(Baseball randomBall, int expected) {
        Baseball baseball = new Baseball("123");
        baseball.calculateStrikeBall(randomBall);
        assertEquals(baseball.getStrikeCount().intValue(), expected);
    }

    private static Stream<Arguments> provideCalculateStrikeCountTest() {
        return Stream.of(
            Arguments.of(new Baseball("123"), 3),
            Arguments.of(new Baseball("456"), 0)
        );
    }

    @DisplayName("ball 개수를 잘 계산하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideCalculateBallCountTest")
    void calculateBallCountTest(Baseball randomBall, int expected) {
        Baseball baseball = new Baseball("123");
        baseball.calculateBall(randomBall);
        assertEquals(baseball.getBallCount().intValue(), expected);
    }

    private static Stream<Arguments> provideCalculateBallCountTest() {
        return Stream.of(
            Arguments.of(new Baseball("213"), 2),
            Arguments.of(new Baseball("456"), 0)
        );
    }
}
