package com.jaeeyeonling.baseball.referee;

import com.jaeeyeonling.baseball.ball.Balls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("스트라이크 판정에 대해 테스트한다.")
class StrikeRuleTest {

    private JudgeRule judgeRule;

    @BeforeEach
    void setUp() {
        judgeRule = StrikeRule.getInstance();
    }

    @DisplayName("동일한 볼일 경우 스트라이크로 판정한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "543"})
    void isStrike(final String value) {
        // given
        final var myBall = Balls.of(value);
        final var otherBall = Balls.of(value);

        for (var i = 0; i < Balls.SIZE; i++) {
            // when
            final var isStrike = judgeRule.judges(myBall, otherBall, i);

            // then
            assertThat(isStrike).isTrue();
        }
    }

    @DisplayName("동일한 볼이 아닐 경우 스트라이크로 판정하지 않는다.")
    @ParameterizedTest
    @CsvSource({
            "123,456",
            "456,789",
            "234,342",
    })
    void notStrike(final String rawMyBall,
                   final String rawOtherBall) {
        // given
        final var myBall = Balls.of(rawMyBall);
        final var otherBall = Balls.of(rawOtherBall);

        for (var i = 0; i < Balls.SIZE; i++) {
            // when
            final var isStrike = judgeRule.judges(myBall, otherBall, i);

            // then
            assertThat(isStrike).isFalse();
        }
    }
}
