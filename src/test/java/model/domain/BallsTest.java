package model.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    @Test
    void of() {
        List<Ball> expectedBalls = Arrays.asList(Ball.of(1), Ball.of(2), Ball.of(3));

        Balls balls = Balls.of("123");

        assertThat(balls).isEqualTo(new Balls(expectedBalls));
    }

    @Test
    void equals() {
        List<Ball> balls = Arrays.asList(Ball.of(1), Ball.of(2), Ball.of(3));
        List<Ball> expectedBalls = Arrays.asList(Ball.of(1), Ball.of(2), Ball.of(3));

        assertThat(new Balls(balls)).isEqualTo(new Balls(expectedBalls));
    }

    @Test
    void not_equals() {
        List<Ball> balls = Arrays.asList(Ball.of(1), Ball.of(3), Ball.of(2));
        List<Ball> expectedBalls = Arrays.asList(Ball.of(1), Ball.of(2), Ball.of(3));

        assertThat(new Balls(balls)).isNotEqualTo(new Balls(expectedBalls));
    }

    @Test
    void containCount() {
        List<Ball> balls = Arrays.asList(Ball.of(1), Ball.of(3), Ball.of(2));
        List<Ball> expectedBalls = Arrays.asList(Ball.of(1), Ball.of(2), Ball.of(4));

        assertThat(new Balls(balls).containCount(new Balls(expectedBalls))).isEqualTo(2);
    }

    @Test
    void equalsCount() {
        List<Ball> balls = Arrays.asList(Ball.of(1), Ball.of(3), Ball.of(2));
        List<Ball> expectedBalls = Arrays.asList(Ball.of(1), Ball.of(2), Ball.of(4));

        assertThat(new Balls(balls).equalsCount(new Balls(expectedBalls))).isEqualTo(1);
    }
}
