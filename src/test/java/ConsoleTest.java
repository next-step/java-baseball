import baseball.Console;
import baseball.domain.Score;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleTest {

    @Test
    void input_number() {
        Console console = new Console();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("123".getBytes());
        System.setIn(byteArrayInputStream);

        assertThat(console.getNumber()).isEqualTo(123);
    }

    @Test
    void result_three_strike() {
        Console console = new Console();
        Score score = new Score(3, 0);
        assertThat(console.result(score)).isTrue();
    }

    @Test
    void result_one_strike_one_ball() {
        Console console = new Console();
        Score score = new Score(1, 1);
        assertThat(console.result(score)).isFalse();
    }

    @Disabled
    @Test
    void start_game() {
        Console console = new Console();

        // TODO 3스트라이크 될때까지 숫자를 물어보는 기능
        console.play();
    }

}
