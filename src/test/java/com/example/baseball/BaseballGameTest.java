package com.example.baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BaseballGameTest {

    @Test
    void getRandomNumbers() {
        BaseballGame baseballGame = new BaseballGame();
        int[] randomNumbers = baseballGame.getRandomNumbers();
        assertThat(randomNumbers)
                .isNotNull()
                .isNotEmpty()
                .hasSize(3);
        assertThat(randomNumbers[0]).isBetween(1, 9);
        assertThat(randomNumbers[1]).isBetween(1, 9);
        assertThat(randomNumbers[2]).isBetween(1, 9);
        assertThat(randomNumbers).doesNotHaveDuplicates();
    }
}