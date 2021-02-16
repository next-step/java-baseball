package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @DisplayName("컴퓨터가 임의의 수 3개를 선택")
    @Test
    void generateNumber() {
        // given & when
        Numbers numbers = Computer.generateNumbers();

        // then
        assertThat(numbers).isNotNull();
        assertThat(numbers.digits()).isEqualTo(3);
    }

    @DisplayName("컴퓨터가 선택한 수의 각 자릿수는 항상 distinct")
    @Test
    void distinctNumberElements() {
        // given & when
        Numbers numbers = Computer.generateNumbers();
        String numbersString = numbers.toString();

        // then
        assertThat(numbersString.chars().distinct().count()).isEqualTo(3);
    }
}
