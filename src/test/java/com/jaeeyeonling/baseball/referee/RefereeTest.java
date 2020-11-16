package com.jaeeyeonling.baseball.referee;

import com.jaeeyeonling.baseball.ball.Balls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("심판에 대해 테스트한다.")
class RefereeTest {

    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = Referee.basic();
    }

    @DisplayName("볼들을 입력할 경우 판정 보고서를 받을 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "543"})
    void judges(final String rawBalls) {
        // given
        final var balls = Balls.of(rawBalls);
        final var other = Balls.of(rawBalls);

        // when
        final var report = referee.judges(balls, other);

        // then
        assertThat(report).isNotNull();
    }

    @DisplayName("동일한 볼들을 입력할 경우 완료 상태의 보고서를 받을 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "543"})
    void judgesComplete(final String rawBalls) {
        // given
        final var balls = Balls.of(rawBalls);
        final var other = Balls.of(rawBalls);

        // when
        final var report = referee.judges(balls, other);

        // then
        assertThat(report.isComplete()).isTrue();
    }

    @DisplayName("동일하지 않은 볼들을 입력할 경우 완료 상태가 아닌 보고서를 받을 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "123,456",
            "456,789",
            "234,986",
    })
    void judgesNotComplete(final String rawBalls,
                           final String rawOtherBalls) {
        // given
        final var balls = Balls.of(rawBalls);
        final var other = Balls.of(rawOtherBalls);

        // when
        final var report = referee.judges(balls, other);

        // then
        assertThat(report.isComplete()).isFalse();
    }

    @DisplayName("동일하지 않은 볼들을 입력할 경우 낫싱 상태의 보고서를 받을 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "123,456",
            "456,789",
            "234,986",
    })
    void judgesNothing(final String rawBalls,
                       final String rawOtherBalls) {
        // given
        final var balls = Balls.of(rawBalls);
        final var other = Balls.of(rawOtherBalls);

        // when
        final var report = referee.judges(balls, other);

        // then
        assertThat(report.isNothing()).isTrue();
    }

    @DisplayName("동일한 볼들을 입력할 경우 낫싱 상태가 아닌 보고서를 받을 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "543"})
    void judgesNotNothing(final String rawBalls) {
        // given
        final var balls = Balls.of(rawBalls);
        final var other = Balls.of(rawBalls);

        // when
        final var report = referee.judges(balls, other);

        // then
        assertThat(report.isNothing()).isFalse();
    }
}
