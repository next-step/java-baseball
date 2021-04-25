package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @DisplayName("컴퓨터는 숫자 3개를 선택하여 가지고 있는지 테스트")
    @Test
    void create() {
        Computer computer = new Computer(new BallNumbers("123"));

        assertThat(computer).isEqualTo(new Computer(new BallNumbers("123")));
    }
}
