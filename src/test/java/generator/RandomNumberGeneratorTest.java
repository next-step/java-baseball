package generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("서로 다른 수로 이루어진 size자리의 수를 생성")
    public void generate(int size) {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        int[] numbers = numberGenerator.generate(size);
        assertThat(numbers.length).isEqualTo(size);
    }
}