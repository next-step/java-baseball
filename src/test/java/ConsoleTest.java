import baseball.Console;
import baseball.domain.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleTest {

    public static final String NEW_LINE = "\r\n";
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
    void print_one_ball_score() {
        ByteArrayOutputStream outputStream = systemOutput();
        Score score = new Score(0, 1);
        console.print(score);
        assertThat(outputStream.toString()).hasToString(score.getBall() + " 볼" + NEW_LINE);
    }

    @Test
    void print_one_strike_one_ball_score() {
        ByteArrayOutputStream outputStream = systemOutput();
        Score score = new Score(1, 1);
        console.print(score);
        assertThat(outputStream.toString()).hasToString(score.getStrike() + " 스트라이크 " + score.getBall() + " 볼" + NEW_LINE);
    }

    @Test
    void print_one_strike_score() {
        ByteArrayOutputStream outputStream = systemOutput();
        Score score = new Score(1, 0);
        console.print(score);
        assertThat(outputStream.toString()).hasToString(score.getStrike() + " 스트라이크" + NEW_LINE);
    }

    private ByteArrayOutputStream systemOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
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
