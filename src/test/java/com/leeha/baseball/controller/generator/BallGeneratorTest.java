package com.leeha.baseball.controller.generator;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BallGeneratorTest {

    public static final int CAPACITY = 3;
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 9;

    private static BallGenerator generator;

    @BeforeAll
    public static void initialize() {
        generator = new BallGenerator(CAPACITY, MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }

    @Test
    public void generate_ShouldReturnList() {
        List<Integer> numbers = generator.generate();

        assertThat(numbers)
            .isNotNull()
            .doesNotContainNull()
            .isInstanceOf(List.class);
    }

    @Test
    public void generate_ShouldReturnSizeOfListEqualsCapacity() {
        List<Integer> numbers = generator.generate();

        assertThat(numbers)
            .hasSize(CAPACITY);
    }

    @Test
    public void generate_ShouldNotIncludeDuplicateNumbers() {
        List<Integer> numbers = generator.generate();

        assertThat(numbers)
            .hasSize(new HashSet<>(numbers).size());
    }

    @Test
    public void generate_ShouldNotDuplicatedList() {
        List<Integer> numbers1 = generator.generate();
        List<Integer> numbers2 = generator.generate();

        assertThat(numbers1)
            .isNotEqualTo(numbers2);
    }
}