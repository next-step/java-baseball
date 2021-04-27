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

    @Test
    void compareNumbers_ShouldReturnTrue() {
        BaseballGame baseballGame = new BaseballGame();
        assertThat(baseballGame.compareNumbers(new int[] {1, 2, 3}, new int[] {1, 2, 3})).isTrue();
        assertThat(baseballGame.compareNumbers(new int[] {2, 3, 4}, new int[] {2, 3, 4})).isTrue();
    }

    @Test
    void compareNumbers_ShouldReturnFalse() {
        BaseballGame baseballGame = new BaseballGame();
        assertThat(baseballGame.compareNumbers(new int[] {1, 2, 3}, new int[] {3, 2, 1})).isFalse();
        assertThat(baseballGame.compareNumbers(new int[] {2, 3, 4}, new int[] {5, 6, 7})).isFalse();
    }

    @Test
    void checkStrikeCount() {
        BaseballGame baseballGame = new BaseballGame();
        assertThat(baseballGame.checkStrikeCount(new int[] {1, 2, 3}, new int[] {3, 2, 1})).isEqualTo(1);
        assertThat(baseballGame.checkStrikeCount(new int[] {1, 2, 3}, new int[] {4, 5, 6})).isEqualTo(0);
    }

    @Test
    void checkBallCount() {
        BaseballGame baseballGame = new BaseballGame();
        assertThat(baseballGame.checkBallCount(new int[] {1, 2, 3}, new int[] {3, 2, 1})).isEqualTo(2);
        assertThat(baseballGame.checkBallCount(new int[] {1, 2, 3}, new int[] {4, 5, 6})).isEqualTo(0);
    }

    @Test
    void convertNumbersStringToArray_ShouldBeValid() {
        BaseballGame baseballGame = new BaseballGame();
        assertThat(baseballGame.convertNumbersStringToArray("123"))
                .isNotNull()
                .isNotEmpty()
                .hasSize(3)
                .containsExactly(1, 2, 3);
    }

    @Test
    void isValidContinueMessage_ShouldReturnTrue() {
        BaseballGame baseballGame = new BaseballGame();
        assertThat(baseballGame.isValidContinueMessage("1")).isTrue();
        assertThat(baseballGame.isValidContinueMessage("2")).isTrue();
    }

    @Test
    void isValidContinueMessage_ShouldReturnFalse() {
        BaseballGame baseballGame = new BaseballGame();
        assertThat(baseballGame.isValidContinueMessage("3")).isFalse();
        assertThat(baseballGame.isValidContinueMessage("aaa")).isFalse();
    }
}