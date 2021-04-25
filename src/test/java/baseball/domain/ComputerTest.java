package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @DisplayName("컴퓨터는 숫자 3개를 선택하여 가지고 있는지 테스트")
    @Test
    void create() {
        Computer computer = new Computer(new BallNumbers("123"));

        assertThat(computer).isEqualTo(new Computer(new BallNumbers("123")));
    }

    @DisplayName("사용자와 컴퓨터가 선택한 숫자 매칭 - 스트라이크의 경우")
    @ParameterizedTest
    @CsvSource(value = {"123:123:3", "428:325:1", "369:189:1", "274:273:2"}, delimiter = ':')
    void match_strike(String comNumbers, String userNumbers, int strikeCount) {
        Computer computer = new Computer(new BallNumbers(comNumbers));
        Result result = computer.match(new BallNumbers(userNumbers));

        assertThat(result.countStrike()).isEqualTo(strikeCount);
    }

    @DisplayName("사용자와 컴퓨터가 선택한 숫자 매칭 - 볼의 경우")
    @ParameterizedTest
    @CsvSource(value = {"312:123:3", "428:352:1", "369:193:2", "427:273:2"}, delimiter = ':' )
    void match_ball(String comNumbers, String userNumbers, int ballCount) {
        Computer computer = new Computer(new BallNumbers(comNumbers));
        Result result = computer.match(new BallNumbers(userNumbers));

        assertThat(result.countBall()).isEqualTo(ballCount);
    }

    @DisplayName("사용자와 컴퓨터가 선택한 숫자 매칭 - 낫싱의 경우")
    @ParameterizedTest
    @CsvSource(value = {"123:456", "428:315", "379:182", "274:861"}, delimiter = ':')
    void match_nothing(String comNumbers, String userNumbers) {
        Computer computer = new Computer(new BallNumbers(comNumbers));
        Result result = computer.match(new BallNumbers(userNumbers));

        assertThat(result.isNothing()).isTrue();
    }
}
