package com.woowahan.precourse.baseball.rule;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallRuleTest {

    private String[] gameNumbers;

    @BeforeEach
    void init() {
        this.gameNumbers = new String[] {"5", "4", "3"};
    }

    @Test
    @DisplayName("동일한 자리의 gameNumber와 inputNumber가 같으면 isStrike는 true 다르면 isStrike는 false")
    void isStrikeTest() {

        String firstInputNumber = "7";
        String secondInputNumber = "4";

        assertThat(BaseBallRule.isStrike(this.gameNumbers[0], firstInputNumber)).isFalse();
        assertThat(BaseBallRule.isStrike(this.gameNumbers[1], secondInputNumber)).isTrue();
    }

    @Test
    @DisplayName("inputNumber가 strike가 아니고 gameNumbers에 inputNumber가 포함되어 있으면 ball")
    void isBallTest() {

        String firstInputNumber = "3";
        String secondInputNumber = "8";
        String thirdInputNumber = "4";

        assertThat(BaseBallRule.isBall(this.gameNumbers, firstInputNumber, 0)).isTrue();
        assertThat(BaseBallRule.isBall(this.gameNumbers, secondInputNumber, 1)).isFalse();
        assertThat(BaseBallRule.isBall(this.gameNumbers, thirdInputNumber, 2)).isTrue();
    }
}
