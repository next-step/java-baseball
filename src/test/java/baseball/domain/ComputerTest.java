package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    private ArrayList<Integer> numbers;

    @Test
    @DisplayName("Set Size 3 Check")
    void size_check() {
        numbers = Computer.createNumbers();
        assertThat(numbers.size()).isEqualTo(3);
    }
}