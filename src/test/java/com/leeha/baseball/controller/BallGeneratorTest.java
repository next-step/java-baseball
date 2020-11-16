package com.leeha.baseball.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.leeha.baseball.controller.generator.BallGenerator;

public class BallGeneratorTest {

    public static final int CAPACITY = 3;
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 9;

    private static BallGenerator ballGenerator;

    @BeforeAll
    public static void initialize() {
        ballGenerator = new BallGenerator(CAPACITY, MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }

    @Test
    public void generate_ShouldReturnList() {
        List<Integer> generate = ballGenerator.generate();

        assertThat(generate)
            .isNotNull()
            .doesNotContainNull()
            .isInstanceOf(List.class);
    }

    @Test
    public void generate_ShouldReturnSizeOfListEqualsCapacity() {
        List<Integer> generate = ballGenerator.generate();

        assertThat(generate)
            .hasSize(CAPACITY);
    }

    @Test
    public void generate_ShouldNotIncludeDuplicateNumbers() {
        List<Integer> generate = ballGenerator.generate();

        assertThat(generate)
            .hasSize(new HashSet<>(generate).size());
    }
}