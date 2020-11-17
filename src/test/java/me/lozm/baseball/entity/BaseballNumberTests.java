package me.lozm.baseball.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static me.lozm.baseball.common.CommonUtils.ANSWER_SIZE;
import static me.lozm.baseball.common.CommonUtils.REG_EXP_ANSWER;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberTests {

    private BaseballNumber baseballNumber;
    private String randomNumber;

    @BeforeEach
    void setDefault() {
        baseballNumber = new BaseballNumber();
        randomNumber = baseballNumber.getRandomNumberToString();
        System.out.println("randomNumber = " + randomNumber);
    }

    @DisplayName("생성된 수가 설정된 정답 길이와 같은지 확인")
    @Test
    void testRandomNumberLengthIsAnswerSize() {
        // Given
        // When
        // Then
        assertThat(randomNumber.length()).isEqualTo(ANSWER_SIZE);
    }

    @DisplayName("생성된 수가 1에서 9 사이의 수로 이루어져 있는지 확인")
    @Test
    void testRandomNumberConsistsOfRightNumber() {
        // Given
        // When
        // Then
        assertThat(randomNumber.matches(REG_EXP_ANSWER)).isTrue();
    }

    @DisplayName("생성된 수의 각 자리 수가 모두 서로 다른지 확인")
    @Test
    void testEachRandomNumberIsNotDuplicated() {
        // Given
        // When
        String firstValue = String.valueOf(randomNumber.charAt(0));
        System.out.println("firstValue = " + firstValue);
        String secondValue = String.valueOf(randomNumber.charAt(1));
        System.out.println("secondValue = " + secondValue);
        String thirdValue = String.valueOf(randomNumber.charAt(2));
        System.out.println("thirdValue = " + thirdValue);

        boolean isNotDuplicated = !firstValue.equals(secondValue)
                && !firstValue.equals(thirdValue)
                && !secondValue.equals(thirdValue);

        // Then
        assertThat(isNotDuplicated).isTrue();
    }

}