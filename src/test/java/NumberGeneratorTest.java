import baseball.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {
    NumberGenerator numberGenerator;

    @BeforeEach()
    void setup() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    void generate_ShouldReturn3DigitNumber() {
        String numbers = numberGenerator.generate();

        assertThat(Integer.parseInt(numbers)).isLessThan(999);
    }

    @Test
    void generate_ShouldReturnDifferentNumber() {
        String numbers = numberGenerator.generate();

        Set<Character> set = new HashSet<>();
        for (char c : numbers.toCharArray()) {
            set.add(c);
        }

        assertThat(set).hasSize(3);
    }

    @Test
    void generate_ShouldReturnRandomNumber() {
        final int LOOP_SIZE = 10;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < LOOP_SIZE; i++) {
            set.add(numberGenerator.generate());
        }

        assertThat(set.size()).isGreaterThan(LOOP_SIZE - 2);
    }
}
