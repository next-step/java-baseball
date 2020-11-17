package me.lozm.baseball.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballResultTests {

    private BaseballResult baseballResult;


    @BeforeEach
    void setDefault() {
        baseballResult = new BaseballResult();
    }

    @DisplayName("Strike 가 3번 카운트 되는지 확인")
    @Test
    void testThreeStrikeCount() {
        // Given
        BaseballNumber baseballNumber = new BaseballNumber();
        String targetNumber = baseballNumber.getRandomNumberToString();
        System.out.println("targetNumber = " + targetNumber);

        // When
        String sourceNumber = targetNumber;
        System.out.println("sourceNumber = " + sourceNumber);

        baseballResult.checkAnswer(sourceNumber, targetNumber);

        // Then
        assertThat(baseballResult.getStrike()).isEqualTo(3);
        assertThat(baseballResult.getBall()).isEqualTo(0);
    }

    @DisplayName("Strike 가 1번, Ball 이 2번 카운트 되는지 확인")
    @Test
    void testStrikeAndBallCount() {
        // Given
        String sourceNumber = "425";
        System.out.println("sourceNumber = " + sourceNumber);
        String targetNumber = "452";
        System.out.println("targetNumber = " + targetNumber);

        // When
        baseballResult.checkAnswer(sourceNumber, targetNumber);

        // Then
        assertThat(baseballResult.getStrike()).isEqualTo(1);
        assertThat(baseballResult.getBall()).isEqualTo(2);
    }

    @DisplayName("Strike 가 0번, Ball 이 3번 카운트 되는지 확인")
    @Test
    void testBallCount() {
        // Given
        String sourceNumber = "456";
        System.out.println("sourceNumber = " + sourceNumber);
        String targetNumber = "564";
        System.out.println("targetNumber = " + targetNumber);

        // When
        baseballResult.checkAnswer(sourceNumber, targetNumber);

        // Then
        assertThat(baseballResult.getStrike()).isEqualTo(0);
        assertThat(baseballResult.getBall()).isEqualTo(3);
    }

    @DisplayName("아무 것도 카운트 되지않는지 확인")
    @Test
    void testNothingCount() {
        // Given
        String sourceNumber = "456";
        System.out.println("sourceNumber = " + sourceNumber);
        String targetNumber = "789";
        System.out.println("targetNumber = " + targetNumber);

        // When
        baseballResult.checkAnswer(sourceNumber, targetNumber);

        // Then
        assertThat(baseballResult.getStrike()).isEqualTo(0);
        assertThat(baseballResult.getBall()).isEqualTo(0);
    }

}