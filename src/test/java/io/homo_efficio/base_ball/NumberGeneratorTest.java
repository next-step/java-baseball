package io.homo_efficio.base_ball;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class NumberGeneratorTest {

    @RepeatedTest(1000)
    void check_3_digit_unique() {
        int len = 3;
        String number = NumberGenerator.generate(len);

        Set<String> numbers = new HashSet<>(len);
        String[] split = number.split("");
        for (String num : split) {
            numbers.add(num);
        }

        assertThat(number.length()).isEqualTo(len);
        assertThat(numbers.size()).isEqualTo(len);
    }

    @ParameterizedTest(name = "숫자 문자열 길이: {0}")
    @MethodSource("len")
    void check_arbitrary_len_digit_unique(int len) {
        String number = NumberGenerator.generate(len);

        Set<String> numbers = new HashSet<>(len);
        String[] split = number.split("");
        for (String num : split) {
            numbers.add(num);
        }

        assertThat(number.length()).isEqualTo(len);
        assertThat(numbers.size()).isEqualTo(len);
    }

    private static Stream<Arguments> len() {
        return IntStream.range(3, 10)
                .mapToObj(len -> Arguments.of(len));
    }
}
