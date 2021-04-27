package com.example.baseball;

import org.junit.jupiter.api.DisplayName;
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

    @Test
    void isValidInputNumbersString_ShouldReturnTrue() {
        BaseballGame baseballGame = new BaseballGame();
        assertThat(baseballGame.isValidInputNumbersString("123")).isTrue();
        assertThat(baseballGame.isValidInputNumbersString("135")).isTrue();
        assertThat(baseballGame.isValidInputNumbersString("321")).isTrue();
    }

    @Test
    void isValidInputNumbersString_ShouldReturnFalse() {
        BaseballGame baseballGame = new BaseballGame();
        assertThat(baseballGame.isValidInputNumbersString("012")).isFalse();
        assertThat(baseballGame.isValidInputNumbersString("1222")).isFalse();
        assertThat(baseballGame.isValidInputNumbersString("112")).isFalse();
    }
}