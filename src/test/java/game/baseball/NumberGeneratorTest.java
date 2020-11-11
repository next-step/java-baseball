package game.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @Test
    @DisplayName("범위 내의 임의의 랜덤 숫자 생성")
    void generateNumberInRange() {
        List<Integer> numbers = NumberGenerator.shuffleAndGet();
        for (Integer number : numbers) {
            assertThat(number).isBetween(1, 9);
        }
    }
}
