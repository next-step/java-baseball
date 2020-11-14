package com.game.baseball;

import com.game.exception.GameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseballGameTest {

    BaseballGame baseballGame;
    String target;

    @BeforeEach
    void init() {
        this.baseballGame = new BaseballGame();
        this.target = "713";
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void isValidInput_successTest(String input) {
        // when
        boolean isValidInput = baseballGame.isValidInput(input);

        // then
        assertThat(isValidInput).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"112", "1234", "abc", "abcd", "12a", "123a"})
    void isValidInput_failureTest(String input) {
        // when & then
        assertThrows(GameException.class, () -> baseballGame.isValidInput(input));
    }

    @Test
    void isValidBaseballNumber_successTest() {
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
        String input = "123";

        // when
        BaseballGameResult baseballGameResult = baseballGame.play(target, input);
        System.out.println(baseballGameResult.toString());

        // then
        assertThat(baseballGameResult.getStrike()).isEqualTo(1);
        assertThat(baseballGameResult.getBall()).isEqualTo(1);
    }

    @Test
    void verifyInput_1B_Test() {
        // given
        String input = "145";

        // when
        BaseballGameResult baseballGameResult = baseballGame.play(target, input);
        System.out.println(baseballGameResult.toString());

        // then
        assertThat(baseballGameResult.getStrike()).isZero();
        assertThat(baseballGameResult.getBall()).isEqualTo(1);
    }

    @Test
    void verifyInput_2B_Test() {
        // given
        String input = "671";

        // when
        BaseballGameResult baseballGameResult = baseballGame.play(target, input);
        System.out.println(baseballGameResult.toString());

        // then
        assertThat(baseballGameResult.getStrike()).isZero();
        assertThat(baseballGameResult.getBall()).isEqualTo(2);
    }

    @Test
    void verifyInput_1S_Test() {
        // given
        String input = "216";

        // when
        BaseballGameResult baseballGameResult = baseballGame.play(target, input);
        System.out.println(baseballGameResult.toString());

        // then
        assertThat(baseballGameResult.getStrike()).isEqualTo(1);
        assertThat(baseballGameResult.getBall()).isZero();
    }

    @Test
    void verifyInput_3S_Test() {
        // given
        String input = "713";

        // when
        BaseballGameResult baseballGameResult = baseballGame.play(target, input);
        System.out.println(baseballGameResult.toString());

        // then
        assertThat(baseballGameResult.getStrike()).isEqualTo(3);
        assertThat(baseballGameResult.getBall()).isZero();
    }

    @Test
    void verifyInput_Nothing_Test() {
        // given
        String input = "824";

        // when
        BaseballGameResult baseballGameResult = baseballGame.play(target, input);
        System.out.println(baseballGameResult.toString());

        // then
        assertThat(baseballGameResult.getStrike()).isZero();
        assertThat(baseballGameResult.getBall()).isZero();
    }
}
