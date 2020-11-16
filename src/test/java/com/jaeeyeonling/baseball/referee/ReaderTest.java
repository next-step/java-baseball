package com.jaeeyeonling.baseball.referee;

import com.jaeeyeonling.baseball.ball.Balls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("판독기에 대해 테스트한다.")
class ReaderTest {

    private JudgeRule alwaysTrueRule;

    private JudgeRule alwaysFalseRule;

    @BeforeEach
    void setUp() {
        alwaysTrueRule = (balls, other, index) -> true;
        alwaysFalseRule = (balls, other, index) -> false;
    }

    @DisplayName("빌더를 통해 생성할 수 있다.")
    @Test
    void basicBuilder() {
        // when
        final var reader = Reader.builder()
                .build();

        // then
        assertThat(reader).isNotNull();
    }

    @DisplayName("빌더를 통해 커스텀하게 생성할 수 있다.")
    @Test
    void customBuilder() {
        // when
        final var reader = Reader.builder()
                .strikeRule(alwaysTrueRule)
                .ballRule(alwaysTrueRule)
                .missRule(alwaysTrueRule)
                .build();

        // then
        assertThat(reader).isNotNull();
    }

    @DisplayName("기본 조건으로 생성할 수 있다.")
    @Test
    void basic() {
        // when
        final var reader = Reader.basic();

        // then
        assertThat(reader).isNotNull();
    }

    @DisplayName("스트라이크를 판정할 수 있다.")
    @Test
    void readoutStrike() {
        // given
        final var reader = Reader.builder()
                .strikeRule(alwaysTrueRule)
                .ballRule(alwaysFalseRule)
                .missRule(alwaysFalseRule)
                .build();
        final var balls = Balls.of("123");
        final var expect = Judge.STRIKE;

        for (var i = 0; i < Balls.SIZE; i++) {
            // when
            final var result = reader.readout(balls, balls, i);

            // then
            assertThat(result).isEqualTo(expect);
        }
    }

    @DisplayName("볼을 판정할 수 있다.")
    @Test
    void readoutBall() {
        // given
        final var reader = Reader.builder()
                .strikeRule(alwaysFalseRule)
                .ballRule(alwaysTrueRule)
                .missRule(alwaysFalseRule)
                .build();
        final var balls = Balls.of("123");
        final var expect = Judge.BALL;

        for (var i = 0; i < Balls.SIZE; i++) {
            // when
            final var result = reader.readout(balls, balls, i);

            // then
            assertThat(result).isEqualTo(expect);
        }
    }

    @DisplayName("미스를 판정할 수 있다.")
    @Test
    void readoutMiss() {
        // given
        final var reader = Reader.builder()
                .strikeRule(alwaysFalseRule)
                .ballRule(alwaysFalseRule)
                .missRule(alwaysTrueRule)
                .build();
        final var balls = Balls.of("123");
        final var expect = Judge.MISS;

        for (var i = 0; i < Balls.SIZE; i++) {
            // when
            final var result = reader.readout(balls, balls, i);

            // then
            assertThat(result).isEqualTo(expect);
        }
    }

    @DisplayName("모든 판정 조건에 만족하지 않을 경우 예외처리 한다.")
    @Test
    void readoutException() {
        // given
        final var reader = Reader.builder()
                .strikeRule(alwaysFalseRule)
                .ballRule(alwaysFalseRule)
                .missRule(alwaysFalseRule)
                .build();
        final var balls = Balls.of("123");
        final var expect = Judge.MISS;

        for (var i = 0; i < Balls.SIZE; i++) {
            final var constIndex = i;

            // when / then
            assertThrows(UnsupportedJudgeException.class, () -> reader.readout(balls, balls, constIndex));
        }
    }
}
