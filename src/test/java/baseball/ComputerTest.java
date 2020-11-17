package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @DisplayName("컴퓨터가 생성한 정답이 서로 다른 숫자인지 테스트")
    @Test
    public void testAnswer() {
        Computer computer = new Computer();
        for (int i = 0; i < 10000; i++) {
            computer.createAnswer();
            assertThat(computer.getAnswer().get(0)).isNotEqualTo(computer.getAnswer().get(1));
            assertThat(computer.getAnswer().get(1)).isNotEqualTo(computer.getAnswer().get(2));
            assertThat(computer.getAnswer().get(0)).isNotEqualTo(computer.getAnswer().get(2));
        }
    }
}
