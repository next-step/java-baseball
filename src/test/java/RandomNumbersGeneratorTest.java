import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RandomNumbersGeneratorTest {

    @DisplayName("게임에 사용되는 3개의 숫자는 1-9 사이이며 중복 숫자를 사용할 수 없음")
    @RepeatedTest(100)
    void test01() {

        int expectedMinNumber = 1;
        int expectedMaxNumber = 9;

        RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator(new RandomNumberGenerator());
        List<Integer> numbers = randomNumbersGenerator.makeNumbers();

        for (int num : numbers) {
            assertThat(num).isGreaterThanOrEqualTo(expectedMinNumber)
                           .isLessThanOrEqualTo(expectedMaxNumber);
        }

        assertNotEquals(numbers.get(0), numbers.get(1));
        assertNotEquals(numbers.get(1), numbers.get(2));
        assertNotEquals(numbers.get(2), numbers.get(0));
    }
}