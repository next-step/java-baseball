package model.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallFactoryTest {

    @Test
    void createBalls() {
        assertThat(BallFactory.createBalls()).hasSize(3);
    }
}
