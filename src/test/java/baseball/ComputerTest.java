package baseball;

import baseball.model.Computer;
import baseball.value.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    Computer computer;

    @BeforeEach
    public void init() {
        computer = new Computer();
        computer.generateBalls();
    }

    @Test
    public void generateBalls() {
        int[] balls = computer.getBalls();
        assertThat(balls).isNotEmpty().hasSize(3);

        for (int ball : balls) {
            assertThat(ball).isBetween(1, 9);
        }
    }
}
