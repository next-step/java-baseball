package com.ssabae.woowahantech.domain;

import com.ssabae.woowahantech.domain.baseballnumber.BaseballNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-16
 */
@DisplayName("게임값과 입력값에 따른 판정 테스트 클래스")
class JudgmentTest {

    private final Judgment judgment = new Judgment();

    @Test
    @DisplayName("게임값과 입력값에 따른 판정 테스트 (correct)")
    void isCorrectTest() {
        // given
        List<Integer> gameNumberList = Arrays.asList(1, 2, 3);
        List<Integer> userInputList = Arrays.asList(1, 2, 3);
        BaseballNumbers gameNumbers = new BaseballNumbers(gameNumberList);
        BaseballNumbers userInputNumbers = new BaseballNumbers(userInputList);
        // when
        boolean correct = judgment.isCorrect(gameNumbers, userInputNumbers);
        // then
        assertThat(correct).isTrue();
    }

    @Test
    @DisplayName("게임값과 입력값에 따른 판정 테스트 (incorrect)")
    void isCorrectFailureTest() {
        // given
        List<Integer> gameNumberList = Arrays.asList(1, 2, 3);
        List<Integer> userInputList = Arrays.asList(1, 2, 4);
        BaseballNumbers gameNumbers = new BaseballNumbers(gameNumberList);
        BaseballNumbers userInputNumbers = new BaseballNumbers(userInputList);
        // when
        boolean correct = judgment.isCorrect(gameNumbers, userInputNumbers);
        // then
        assertThat(correct).isFalse();
    }


}