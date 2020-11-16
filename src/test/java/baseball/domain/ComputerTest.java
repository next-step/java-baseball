package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @DisplayName("중복없이 1부터 9까지 숫자 3개를 잘 선택하는가")
    @Test
    void chooseNumbersTest() {
        Computer computer = new Computer();
        Numbers numbers = computer.chooseNumbers();
        assertThat(numbers).isNotNull();

        List<Integer> choiceNumbers = numbers.getChoiceNumbers();
        assertThat(choiceNumbers)
                .isNotEmpty()
                .allMatch(number -> number > 0 && number < 10)
                .hasSize(Game.BASEBALL_NUMBERS_SIZE);

        assertThat(new HashSet<>(choiceNumbers))
                .hasSize(Game.BASEBALL_NUMBERS_SIZE);
    }
}
