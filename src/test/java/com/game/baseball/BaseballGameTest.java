package com.game.baseball;

import com.game.exception.GameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseballGameTest {

    BaseballGame baseballGame;
    String targetNumber;

    @BeforeEach
    void init() {
        this.baseballGame = new BaseballGame();
        this.targetNumber = "713";
    }

    @Test
    void isValidInput_successTest() {
        // given
        String input = "123";

        // when
        boolean isValidInput = baseballGame.isValidInput(input);

        // then
        assertThat(isValidInput).isTrue();
    }

    @Test
    void isValidInput_failureTest() {
        // given
        String input = "112";

        // when & then
        assertThrows(GameException.class, () -> baseballGame.isValidInput(input));
    }

    @Test
    void isValidBaseBallNumber_successTest() {
        // given
        String number = baseballGame.generateNumber();

        // when
        int numberLength = number.length();

        // then
        assertThat(numberLength).isEqualTo(3);
    }

    @Test
    void verifyInput_1S1B_Test() {
        // given
        String inputNumber = "123";

        // when
        BaseballGameResult baseballGameResult = baseballGame.play(targetNumber, inputNumber);
        System.out.println(baseballGameResult.toString());

        // then
        assertThat(baseballGameResult.getStrike()).isEqualTo(1);
        assertThat(baseballGameResult.getBall()).isEqualTo(1);
    }

    @Test
    void verifyInput_1B_Test() {
        // given
        String inputNumber = "145";

        // when
        BaseballGameResult baseballGameResult = baseballGame.play(targetNumber, inputNumber);
        System.out.println(baseballGameResult.toString());

        // then
        assertThat(baseballGameResult.getStrike()).isZero();
        assertThat(baseballGameResult.getBall()).isEqualTo(1);
    }

    @Test
    void verifyInput_2B_Test() {
        // given
        String inputNumber = "671";

        // when
        BaseballGameResult baseballGameResult = baseballGame.play(targetNumber, inputNumber);
        System.out.println(baseballGameResult.toString());

        // then
        assertThat(baseballGameResult.getStrike()).isZero();
        assertThat(baseballGameResult.getBall()).isEqualTo(2);
    }

    @Test
    void verifyInput_1S_Test() {
        // given
        String inputNumber = "216";

        // when
        BaseballGameResult baseballGameResult = baseballGame.play(targetNumber, inputNumber);
        System.out.println(baseballGameResult.toString());

        // then
        assertThat(baseballGameResult.getStrike()).isEqualTo(1);
        assertThat(baseballGameResult.getBall()).isZero();
    }

    @Test
    void verifyInput_3S_Test() {
        // given
        String inputNumber = "713";

        // when
        BaseballGameResult baseballGameResult = baseballGame.play(targetNumber, inputNumber);
        System.out.println(baseballGameResult.toString());

        // then
        assertThat(baseballGameResult.getStrike()).isEqualTo(3);
        assertThat(baseballGameResult.getBall()).isZero();
    }

    @Test
    void verifyInput_Nothing_Test() {
        // given
        String inputNumber = "824";

        // when
        BaseballGameResult baseballGameResult = baseballGame.play(targetNumber, inputNumber);
        System.out.println(baseballGameResult.toString());

        // then
        assertThat(baseballGameResult.getStrike()).isZero();
        assertThat(baseballGameResult.getBall()).isZero();
    }
}
