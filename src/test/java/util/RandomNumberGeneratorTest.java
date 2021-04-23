package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new RandomNumberGenerator().makeNumbersLessThanTen();
    }

    @DisplayName("1부터 9까지 랜덤 숫자 만들기 테스트")
    @Test
    void generate_random_number_min_one_max_nine() {
        Random random = new Random();
        int count = 0;
        while (count < 10000) {
            int max = 9;
            int min = 1;
            int num = random.nextInt(max - min + 1) + min;
            assertThat(num).isLessThan(10);
            assertThat(num).isNotEqualTo(0);
            count++;
        }
    }

    @DisplayName("3자리 숫자 생성 테스트")
    @Test
    void generate_random_number_size_three() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("3 자리 숫자가 각각 1부터 9까지의 숫자중 하나인지 테스트")
    @Test
    void random_number_contains_min_one_max_nine() {
        assertThat(numbers.contains(10)).isFalse();
        assertThat(numbers.contains(0)).isFalse();
    }
}