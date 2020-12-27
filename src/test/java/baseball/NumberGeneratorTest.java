package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final int NUMBER_OF_TESTS = 10;

    @Test
    @DisplayName("중복되지 않은 숫자를 반환한다.")
    public void getUniqueNumberTest() {
        Set<Integer> numberSet = Set.of(1, 2, 3, 5, 6, 7, 8, 9);
        int number = numberGenerator.getUniqueNumber(numberSet);
        assertThat(number).isEqualTo(4);
    }

    @Test
    @DisplayName("사이즈가 3인 리스트를 반환한다.")
    public void generate3NumbersTest() {
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            List<Integer> numbers = numberGenerator.generate();
            assertThat(numbers.size()).isEqualTo(3);
        }
    }

    @Test
    @DisplayName("1~9까지의 숫자가 생성된다.")
    public void generateRangeTest() {
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            List<Integer> numbers = numberGenerator.generate();
            for (int number : numbers) {
                assertThat(number).isBetween(1, 9);
            }
        }
    }
}
