package com.leeha.baseball.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BallGeneratorTest {

    public static final int CAPACITY = 3;

    private static BallGenerator ballGenerator;

    @BeforeAll
    public static void initialize() {
        ballGenerator = new BallGenerator(CAPACITY);
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