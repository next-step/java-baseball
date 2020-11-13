package io.homo_efficio.base_ball;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class NumberGeneratorTest {

    @Test
    void check_3_digit_unique() {
        String number = NumberGenerator.generate();

        Set<String> numbers = new HashSet<>(3);
        String[] split = number.split("");
        Collections.addAll(numbers, split);

        assertThat(number.length()).isEqualTo(3);
        assertThat(numbers.size()).isEqualTo(3);
    }
}
