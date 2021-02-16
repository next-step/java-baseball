package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {

    @DisplayName("컴퓨터가 Null을 반환하는지 확인한다.")
    @Test
    void generateRandomNumberTest() {
        Computer computer = new Computer();
        assertThat(computer.generateRandomNumbers()).isNotNull();
    }
}
