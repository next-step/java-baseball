package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {

    private static Computer computer;

    @BeforeAll
    static void beforeAll() {
        computer = new Computer();
    }

    @DisplayName("컴퓨터가 세개의 숫자를 반환하는지 확인한다.")
    @Test
    void generateRandomNumberTest() {
        assertThat(computer.generateRandomNumbers()).isNotNull();
        assertThat(computer.generateRandomNumbers()).hasSize(3);
    }

    @DisplayName("컴퓨터가 3개의 유니크한 숫자를 반환하는지 확인한다.")
    @Test
    void generateUniqueNumbersTest() {
        Set<Integer> randomNumbers = new HashSet<>(computer.generateRandomNumbers());

        assertThat(randomNumbers.size()).isEqualTo(3);
    }

    @DisplayName("컴퓨터가 생성한 숫자에 0이 포함되는지 확인한다.")
    @Test
    void hasZeroTest() {
        assertThat(computer.generateRandomNumbers()).doesNotContain(0);
    }
}
