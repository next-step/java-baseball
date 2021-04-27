package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomGeneratorTest {

    @Test
    @DisplayName("1 ~ 9까지의 랜덤 숫자 3자리가 생성된다.")
    void randomGenerator() {
        RandomGenerator generator = new RandomGenerator();

        int number = Integer.parseInt(generator.generate());

        assertThat(number).isBetween(111, 1000);
    }
}
