package dev.heowc.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("볼들에 대해 테스트한다.")
class BallsTest {

    @DisplayName("중복되지 않은 3자리의 숫자로 생성한다.")
    @ParameterizedTest
    @MethodSource("provideCreateMethodArguments")
    void create(List<Ball> ballList) {
        final Balls balls = Balls.of(ballList);
        assertThat(balls).isNotNull();
    }

    private static Stream<? extends Arguments> provideCreateMethodArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                Arguments.of(Arrays.asList(Ball.valueOf(4), Ball.valueOf(5), Ball.valueOf(6))),
                Arguments.of(Arrays.asList(Ball.valueOf(7), Ball.valueOf(8), Ball.valueOf(9)))
        );
    }

    @DisplayName("3자리가 아니면 생성할 수 없다.")
    @ParameterizedTest
    @MethodSource("provideCreateInvalidSizeMethodArguments")
    void createInvalidSize(List<Ball> ballList) {
        assertThatThrownBy(() -> {
            Balls.of(ballList);
        }).isInstanceOf(InvalidBallSizeException.class);
    }

    private static Stream<? extends Arguments> provideCreateInvalidSizeMethodArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3), Ball.valueOf(4))),
                Arguments.of(Arrays.asList(Ball.valueOf(5), Ball.valueOf(6))),
                Arguments.of(Arrays.asList())
        );
    }

    @DisplayName("숫자는 중복될 수 없다.")
    @ParameterizedTest
    @MethodSource("provideCreateDuplicatedBallMethodArguments")
    void createDuplicatedBall(List<Ball> ballList) {
        assertThrows(InvalidBallSizeException.class, () -> Balls.of(ballList));
    }

    private static Stream<? extends Arguments> provideCreateDuplicatedBallMethodArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(1), Ball.valueOf(4))),
                Arguments.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(2))),
                Arguments.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(1)))
        );
    }

    @DisplayName("특정 위치의 값이 일치하는지 확인한다.")
    @ParameterizedTest
    @MethodSource("provideMatchMethodArguments")
    void match(Balls balls, Balls otherBalls, int index, boolean expected) {
        final boolean match = balls.match(otherBalls, index);
        assertThat(match).isEqualTo(expected);
    }

    private static Stream<? extends Arguments> provideMatchMethodArguments() {
        return Stream.of(
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(4), Ball.valueOf(5))),
                        0,
                        true
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(4), Ball.valueOf(5), Ball.valueOf(6))),
                        Balls.of(Arrays.asList(Ball.valueOf(4), Ball.valueOf(5), Ball.valueOf(7))),
                        1,
                        true
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(2), Ball.valueOf(3), Ball.valueOf(4))),
                        Balls.of(Arrays.asList(Ball.valueOf(7), Ball.valueOf(8), Ball.valueOf(4))),
                        2,
                        true
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Balls.of(Arrays.asList(Ball.valueOf(4), Ball.valueOf(5), Ball.valueOf(6))),
                        0,
                        false
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(4), Ball.valueOf(5), Ball.valueOf(6))),
                        Balls.of(Arrays.asList(Ball.valueOf(7), Ball.valueOf(8), Ball.valueOf(9))),
                        1,
                        false
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(2), Ball.valueOf(3), Ball.valueOf(4))),
                        Balls.of(Arrays.asList(Ball.valueOf(9), Ball.valueOf(8), Ball.valueOf(6))),
                        2,
                        false
                )
        );
    }

    @DisplayName("특정 위치의 값을 포함하는지 확인한다.")
    @ParameterizedTest
    @MethodSource("provideContainsMethodArguments")
    void contains(Balls balls, Balls otherBalls, boolean expected) {
        for (int i = 0; i < Balls.SIZE; i++) {
            final Ball ball = otherBalls.get(i);
            final boolean contains = balls.indexOf(ball) != -1;

            assertThat(contains).isEqualTo(expected);
        }
    }

    private static Stream<? extends Arguments> provideContainsMethodArguments() {
        return Stream.of(
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Balls.of(Arrays.asList(Ball.valueOf(2), Ball.valueOf(3), Ball.valueOf(1))),
                        true
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(4), Ball.valueOf(6), Ball.valueOf(8))),
                        Balls.of(Arrays.asList(Ball.valueOf(6), Ball.valueOf(8), Ball.valueOf(4))),
                        true
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(3), Ball.valueOf(2), Ball.valueOf(1))),
                        Balls.of(Arrays.asList(Ball.valueOf(2), Ball.valueOf(1), Ball.valueOf(3))),
                        true
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                        Balls.of(Arrays.asList(Ball.valueOf(4), Ball.valueOf(5), Ball.valueOf(6))),
                        false
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(4), Ball.valueOf(5), Ball.valueOf(6))),
                        Balls.of(Arrays.asList(Ball.valueOf(7), Ball.valueOf(8), Ball.valueOf(9))),
                        false
                ),
                Arguments.of(
                        Balls.of(Arrays.asList(Ball.valueOf(2), Ball.valueOf(3), Ball.valueOf(4))),
                        Balls.of(Arrays.asList(Ball.valueOf(9), Ball.valueOf(8), Ball.valueOf(6))),
                        false
                )
        );
    }

    @DisplayName("특정 위치의 값을 조회한다.")
    @ParameterizedTest
    @MethodSource("provideGetMethodArguments")
    void get(List<Ball> ballList) {
        final Balls balls = Balls.of(ballList);

        for (int i = 0; i < Balls.SIZE; i++) {
            final Ball ball = balls.get(i);
            final Ball expect = ballList.get(i);

            assertThat(ball).isEqualTo(expect);
        }
    }

    private static Stream<? extends Arguments> provideGetMethodArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(2), Ball.valueOf(3))),
                Arguments.of(Arrays.asList(Ball.valueOf(2), Ball.valueOf(3), Ball.valueOf(4))),
                Arguments.of(Arrays.asList(Ball.valueOf(5), Ball.valueOf(6), Ball.valueOf(7))),
                Arguments.of(Arrays.asList(Ball.valueOf(1), Ball.valueOf(6), Ball.valueOf(9))),
                Arguments.of(Arrays.asList(Ball.valueOf(8), Ball.valueOf(5), Ball.valueOf(2)))
        );
    }
}
