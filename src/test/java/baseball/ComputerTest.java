package baseball;

import baseball.model.Computer;
import baseball.value.Result;
import baseball.view.Monitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    Monitor monitor;
    Computer computer;

    @BeforeEach
    public void init() {
        monitor = new Monitor();
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

    @Test
    public void checkValidate() {
        int playerBalls = 123;
        Result result = computer.validate(playerBalls);

        monitor.showResult(result);
    }
}