import baseball.Console;
import baseball.domain.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleTest {

    private Console console;

    @BeforeEach
    void setUp() {
        console = new Console();
    }

    @Test
    void input_number() {
        systemInput("123");
        assertThat(console.getNumber()).isEqualTo(123);
    }

    @Test
    void result_three_strike() {
        assertThat(console.result(new Score(3, 0))).isTrue();
    }

    @Test
    void result_one_strike_one_ball() {
        assertThat(console.result(new Score(1, 1))).isFalse();
    }

    @Test
    void print_score() {

    }

    @Disabled
    @Test
    void start_game() {
        Console console = new Console();

        // TODO 3스트라이크 될때까지 숫자를 물어보는 기능
        console.play();
    }

    private void systemInput(String input) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
    }

}
