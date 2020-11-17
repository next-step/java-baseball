package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @DisplayName("램덤으로 3자리 숫자가 생성되는지 테스트")
    @Test
    void generate_random_numbers_test() {

        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when & then
        assertThat(randomNumberGenerator.getNumbers().size()).isEqualTo(3);
    }

}
