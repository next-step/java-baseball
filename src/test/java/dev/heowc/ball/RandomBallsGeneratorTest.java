package dev.heowc.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤 볼들 생성기에 대해 테스트한다.")
class RandomBallsGeneratorTest {

    @DisplayName("랜덤 볼들을 생성한다.")
    @Test
    void generate() {
        final Balls balls = new RandomBallsGenerator().generate();

        assertThat(balls).isNotNull();
    }
}
