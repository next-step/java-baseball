package io.homo_efficio.base_ball;

import org.junit.jupiter.api.RepeatedTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class NumberGeneratorTest {

    @RepeatedTest(1000)
    void check_3_digit_unique() {
        String number = NumberGenerator.generate();

        Set<String> numbers = new HashSet<>(3);
        String[] split = number.split("");
        for (String num : split) {
            numbers.add(num);
        }

        assertThat(number.length()).isEqualTo(3);
        assertThat(numbers.size()).isEqualTo(3);
    }
}
