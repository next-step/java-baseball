package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ComputerTest {
    @Test
    void generateNumbers() {
        Computer computer = new Computer(false);
        List<BaseballNumber> numbers = computer.getNumbers();

        List<BaseballNumber> targets = Arrays.asList(new BaseballNumber(1),
                new BaseballNumber(2), new BaseballNumber(3));

        Assertions.assertThat(numbers).isEqualTo(targets);
    }
}
