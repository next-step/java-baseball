package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    @Test
    @DisplayName("1~9 사이의 중복되지 않은 숫자 생성 (캐싱)")
    void createBaseballNumbers() {
        Computer computer = new Computer();
        assertThat(computer.generate()).isNotNull();
    }
}
