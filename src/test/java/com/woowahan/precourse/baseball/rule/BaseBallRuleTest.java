package com.woowahan.precourse.baseball.rule;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallRuleTest {

    private String gameNumber1;
    private String inputNumber1;
    private String gameNumber2;
    private String inputNumber2;

    @BeforeEach
    void init() {
        this.gameNumber1 = "3";
        this.inputNumber1 = "3";
        this.gameNumber2 = "3";
        this.inputNumber2 = "4";
    }

    @Test
    @DisplayName("gameNumber와 inputNumber가 같으면 isStrike는 true 다르면 isStrike는 false")
    void isStrikeTest() {
        assertThat(BaseBallRule.isStrike(gameNumber1, inputNumber1)).isTrue();
        assertThat(BaseBallRule.isStrike(gameNumber2, inputNumber2)).isFalse();
    }

    @Test
    @DisplayName("gameNumber와 inputNumber가 같으면 isBall은 false 다르면 isBall은 true")
    void isBallTest() {
        assertThat(BaseBallRule.isBall(gameNumber1, inputNumber1)).isFalse();
        assertThat(BaseBallRule.isBall(gameNumber2, inputNumber2)).isTrue();
    }

}
