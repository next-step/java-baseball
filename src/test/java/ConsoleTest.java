import baseball.domain.Score;
import baseball.service.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleTest {

    private static final String NEW_LINE = "\r\n";
    private Console console;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        scanner = new Scanner(System.in);
        console = new Console(scanner);
    }

    @AfterEach
    void finishAll() {
        scanner.close();
    }

    @Test
    void result_three_strike() {
        assertThat(console.isFinish(new Score(3, 0))).isTrue();
    }

    @Test
    void result_one_strike_one_ball() {
        assertThat(console.isFinish(new Score(1, 1))).isFalse();
    }

    @Test
    void print_one_ball_score() {
        ByteArrayOutputStream outputStream = systemOutput();
        Score score = new Score(0, 1);
        console.print(score);
        assertThat(outputStream.toString()).hasToString(score.getBall() + " 볼" + NEW_LINE);
    }

    @Test
    void print_three_ball_score() {
        ByteArrayOutputStream outputStream = systemOutput();
        Score score = new Score(0, 3);
        console.print(score);
        assertThat(outputStream.toString()).hasToString(score.getBall() + " 볼" + NEW_LINE);
    }

    @Test
    void print_four_ball_score() {
        ByteArrayOutputStream outputStream = systemOutput();
        Score score = new Score(0, 4);
        console.print(score);
        assertThat(outputStream.toString()).hasToString("낫싱" + NEW_LINE);
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

    @Test
    void print_three_strike_score() {
        ByteArrayOutputStream outputStream = systemOutput();
        Score score = new Score(3, 0);
        console.print(score);
        assertThat(outputStream.toString())
                .hasToString(score.getStrike() + " 스트라이크" + NEW_LINE + "3개의 숫자를 모두 맞히셨습니다! 게임종료" + NEW_LINE);
    }

    private ByteArrayOutputStream systemOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }

}
