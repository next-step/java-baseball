package com.jaeeyeonling.baseball.ball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤 볼들 생성기에 대해 테스트한다.")
class RandomBaseBallsGeneratorTest {

    private BallsGenerator ballsGenerator;

    @BeforeEach
    void setUp() {
        ballsGenerator = RandomBaseBallsGenerator.INSTANCE;
    }

    @DisplayName("랜덤 볼들을 생성한다.")
    @Test
    void generate() {
        // when
        final var balls = ballsGenerator.generate();

        // then
        assertThat(balls).isNotNull();
    }
}
