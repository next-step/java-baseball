package com.leeha.baseball.controller.generator;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BallGeneratorTest {

    public static final int CAPACITY = 3;
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 9;

    private static BallGenerator generator;

    @BeforeAll
    static void initialize() {
        generator = new BallGenerator(CAPACITY, MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }

    @Test
    void generate_ShouldReturnNonNullList() {
        List<Integer> numbers = generator.generate();

        assertThat(numbers)
            .isNotNull()
            .doesNotContainNull()
            .isInstanceOf(List.class);
    }

    @Test
    void generate_ShouldReturnSizeOfListEqualsCapacity() {
        List<Integer> numbers = generator.generate();

        assertThat(numbers)
            .hasSize(CAPACITY);
    }

    @Test
    void generate_ShouldReturnNumbersWithoutDuplicate() {
        List<Integer> numbers = generator.generate();

        assertThat(numbers)
            .hasSize(new HashSet<>(numbers).size());
    }

    @Test
    void generate_ShouldReturnRandomlyList() {
        List<Integer> numbers1 = generator.generate();
        List<Integer> numbers2 = generator.generate();

        assertThat(numbers1)
            .isNotEqualTo(numbers2);
    }
}
