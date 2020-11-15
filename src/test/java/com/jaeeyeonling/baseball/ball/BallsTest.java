package com.jaeeyeonling.baseball.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("볼들에 대해 테스트한다.")
class BallsTest {

    @DisplayName("중복되지 않은 3자리의 숫자로 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "567", "169", "852"})
    void create(final String rawBalls) {
        // when
        final var positiveDigits = Balls.of(rawBalls);

        // then
        assertThat(positiveDigits).isNotNull();
    }

    @DisplayName("3자리가 아니면 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "24", ""})
    void createFailInvalidSize(final String rawBalls) {
        // when / then
        assertThrows(BallsSizeException.class, () -> Balls.of(rawBalls));
    }

    @DisplayName("0의 숫자를 포함할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"012", "086", "902"})
    void createFailNotZero(final String rawBalls) {
        // when / then
        assertThrows(BallOutOfRangeException.class, () -> Balls.of(rawBalls));
    }

    @DisplayName("숫자는 중복될 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"662", "686", "922"})
    void createDuplicate(final String rawBalls) {
        // when / then
        assertThrows(BallsSizeException.class, () -> Balls.of(rawBalls));
    }

    @DisplayName("특정 위치의 값이 일치하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "567", "169", "852"})
    void match(final String rawBalls) {
        // given
        final var balls = Balls.of(rawBalls);

        for (var i = 0; i < Balls.SIZE; i++) {
            // when
            final var match = balls.match(balls, i);

            // then
            assertThat(match).isTrue();
        }
    }

    @DisplayName("특정 위치의 값이 일치하지 않는지 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "123,456",
            "456,789",
            "234,986",
    })
    void notMatch(final String rawBalls,
                  final String rawOtherBalls) {
        // given
        final var balls = Balls.of(rawBalls);
        final var otherBalls = Balls.of(rawOtherBalls);

        for (var i = 0; i < Balls.SIZE; i++) {
            // when
            final var match = balls.match(otherBalls, i);

            // then
            assertThat(match).isFalse();
        }
    }

    @DisplayName("특정 위치의 값을 포함하는지 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "123,231",
            "468,684",
            "321,213"
    })
    void contains(final String rawBalls,
                  final String rawOtherBalls) {
        // given
        final var balls = Balls.of(rawBalls);
        final var otherBalls = Balls.of(rawOtherBalls);

        for (var i = 0; i < Balls.SIZE; i++) {
            // when
            final var ball = otherBalls.get(i);
            final var contains = balls.contains(ball);

            // then
            assertThat(contains).isTrue();
        }
    }

    @DisplayName("특정 위치의 값을 포함하지 않는지 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "123,456",
            "456,789",
            "234,986",
    })
    void notContains(final String rawBalls,
                     final String rawOtherBalls) {
        // given
        final var balls = Balls.of(rawBalls);
        final var otherBalls = Balls.of(rawOtherBalls);

        for (var i = 0; i < Balls.SIZE; i++) {
            // when
            final var ball = otherBalls.get(i);
            final var contains = balls.contains(ball);

            // then
            assertThat(contains).isFalse();
        }
    }

    @DisplayName("특정 위치의 값을 조회한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "567", "169", "852"})
    void get(final String rawBalls) {
        // given
        final var rawBallsDelimiter = "";
        final var balls = Balls.of(rawBalls);

        for (var i = 0; i < Balls.SIZE; i++) {
            // when
            final var ball = balls.get(i);
            final var rawExpect = rawBalls.split(rawBallsDelimiter)[i];
            final var expect = Ball.valueOf(rawExpect);

            // then
            assertThat(ball).isEqualTo(expect);
        }
    }
}
