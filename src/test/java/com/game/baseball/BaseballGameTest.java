package com.game.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    BaseballGame baseballGame;

    @BeforeEach
    void init() {
        this.baseballGame = new BaseballGame();
    }

    @Test
    void isValidBaseBallNumber_successTest() {
        // given
        String number = baseballGame.generateNumber();

        // when
        int numberLength = number.length();

        // then
        Assertions.assertThat(numberLength).isEqualTo(3);
    }
}
