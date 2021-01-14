import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RandomNumberGenerator 테스트")
class RandomNumbersGeneratorTest {

    @DisplayName("3자리 수인지 테스트")
    @RepeatedTest(100)
    void randomNumber_3digits() {
        // when
        Numbers randomNumbers = RandomNumbersGenerator.generate();
        Set<Integer> numbers = randomNumbers.getNumbers();

        // then
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("모든 자리 수가 1부터 9 사이의 수인지 테스트")
    @RepeatedTest(100)
    void randomNumber_every_digit_between_1_9() {
        // when
        Numbers randomNumbers = RandomNumbersGenerator.generate();
        Set<Integer> numbers = randomNumbers.getNumbers();

        // then
        for (Integer number : numbers) {
            assertThat(number).isBetween(1, 9);
        }
    }
}