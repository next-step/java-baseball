package playball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class HintTest {

    @DisplayName("스크라이크 개수 테스트")
    @ParameterizedTest
    @MethodSource("provideBallsForStrikeCalculateCountTest")
    public void strikeForCalculateCountTest(Balls myBalls, Balls yourBalls, Integer expected) {

        // when
        Integer count = Hint.STRIKE.calculateCount(myBalls, yourBalls);

        // then
        Assertions.assertThat(count).isEqualTo(expected);
    }

    private static Stream<Arguments> provideBallsForStrikeCalculateCountTest() {
        return Stream.of(
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.of(1), Ball.of(2), Ball.of(3))),
                        Balls.of(Arrays.asList(Ball.of(1), Ball.of(2), Ball.of(3))),
                        3
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.of(5), Ball.of(6), Ball.of(7))),
                        Balls.of(Arrays.asList(Ball.of(5), Ball.of(2), Ball.of(7))),
                        2
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.of(8), Ball.of(2), Ball.of(7))),
                        Balls.of(Arrays.asList(Ball.of(9), Ball.of(6), Ball.of(7))),
                        1
                )
        );
    }

    @DisplayName("볼 개수 테스트")
    @ParameterizedTest
    @MethodSource("provideBallsForBallCalculateCountTest")
    public void ballForCalculateCountTest(Balls myBalls, Balls yourBalls, Integer expected) {

        // when
        Integer count = Hint.BALL.calculateCount(myBalls, yourBalls);

        // then
        Assertions.assertThat(count).isEqualTo(expected);
    }

    private static Stream<Arguments> provideBallsForBallCalculateCountTest() {
        return Stream.of(
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.of(1), Ball.of(2), Ball.of(3))),
                        Balls.of(Arrays.asList(Ball.of(1), Ball.of(2), Ball.of(3))),
                        0
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.of(5), Ball.of(6), Ball.of(7))),
                        Balls.of(Arrays.asList(Ball.of(5), Ball.of(7), Ball.of(6))),
                        2
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.of(6), Ball.of(2), Ball.of(7))),
                        Balls.of(Arrays.asList(Ball.of(9), Ball.of(6), Ball.of(7))),
                        1
                )
        );
    }

    @DisplayName("낫싱(포볼) 개수 테스트")
    @ParameterizedTest
    @MethodSource("provideBallsForNothingCalculateCountTest")
    public void nothingForCalculateCountTest(Balls myBalls, Balls yourBalls, Integer expected) {

        // when
        Integer count = Hint.NOTHING.calculateCount(myBalls, yourBalls);

        // then
        Assertions.assertThat(count).isEqualTo(expected);
    }

    private static Stream<Arguments> provideBallsForNothingCalculateCountTest() {
        return Stream.of(
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.of(1), Ball.of(2), Ball.of(3))),
                        Balls.of(Arrays.asList(Ball.of(4), Ball.of(5), Ball.of(6))),
                        3
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.of(5), Ball.of(6), Ball.of(7))),
                        Balls.of(Arrays.asList(Ball.of(5), Ball.of(7), Ball.of(6))),
                        0
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.of(6), Ball.of(2), Ball.of(7))),
                        Balls.of(Arrays.asList(Ball.of(9), Ball.of(6), Ball.of(7))),
                        1
                )
        );
    }
}
