package com.jaeeyeonling.baseball.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("볼에 대해 테스트한다.")
class BallTest {

    @DisplayName("0으로 생성할 수 없다.")
    @Test
    void createZero() {
        // given
        final var value = 0;

        // when / then
        assertThrows(BallOutOfRangeException.class, () -> Ball.valueOf(value));
    }

    @DisplayName(Ball.MIN_VALUE + " 미만의 값으로 생성할 수 없다.")
    @Test
    void createLess() {
        // given
        final var value = Ball.MIN_VALUE - 1;

        // when / then
        assertThrows(BallOutOfRangeException.class, () -> Ball.valueOf(value));
    }

    @DisplayName(Ball.MIN_VALUE + " ~ " + Ball.MAX_VALUE + " 사이의 숫자로 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {Ball.MIN_VALUE, 5, Ball.MAX_VALUE})
    void create(final int value) {
        // when
        final var positiveDigit = Ball.valueOf(value);

        // then
        assertThat(positiveDigit).isNotNull();
    }

    @DisplayName("캐싱을 통해 같은 객체를 보장한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 9})
    void deepEquals(final int value) {
        // when
        final var positiveDigit1 = Ball.valueOf(value);
        final var positiveDigit2 = Ball.valueOf(value);

        // then
        assertAll(() -> assertThat(positiveDigit1).isEqualTo(positiveDigit2),
                () -> assertThat(positiveDigit1 == positiveDigit2).isTrue());
    }
}
