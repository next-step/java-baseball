package baseball;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import customexceptions.DigitOverMaximumException;

public class RandomGeneratorTest {

    private RandomGenerator randomGenerator;

    @BeforeEach
    void setup() {
        this.randomGenerator = new RandomGenerator();
    }

    @Test
    @DisplayName("랜덤 숫자 생성 - 성공")
    void getRandomDigits_succeed() {
        // given
        int digitCount = 3;

        // when
        String output = this.randomGenerator.getRandomDigits(digitCount);

        // then
        List<Integer> digits = new ArrayList<>();
        for (char c : output.toCharArray()) {
            digits.add(c - '0');
        }

        Assertions.assertThat(output.length()).isEqualTo(3);
        Assertions.assertThat(digits).allMatch(d -> d > 0 && d <= 9);
        Assertions.assertThat(output.toCharArray()).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("랜덤 숫자 생성 - 숫자의 개수가 9개를 초과하면 Exception 발생")
    void getRandomDigits_succeed_ThrowsExceptionWhenDigitCountOverNine() {
        // given
        int digitCount = 10;

        // when, then
        Assertions.assertThatThrownBy(() -> {
            String output = this.randomGenerator.getRandomDigits(digitCount);
        }).isInstanceOf(DigitOverMaximumException.class)
                .hasMessageContaining("Digit count must less than 10");
    }
}