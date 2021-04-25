package com.nextstep.baseball.handler;

import com.nextstep.baseball.enums.ErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameLogicHandlerTest {
    private GameLogicHandler gameLogicHandler;

    @BeforeEach
    public void setUp() {
        this.gameLogicHandler = new GameLogicHandler();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "55555555555555555"})
    public void validateInput_ShouldReturnErrorMessageOver(String input) {
        assertThat(gameLogicHandler.validateAndReturnInput(input)).isEqualTo(ErrorMessages.INPUT_LENGTH_OVER.getCode());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", ""})
    public void validateInput_ShouldReturnErrorMessageUnder(String input) {
        assertThat(gameLogicHandler.validateAndReturnInput(input)).isEqualTo(ErrorMessages.INPUT_LENGTH_UNDER.getCode());
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "!@#"})
    public void validateInput_ShouldReturnErrorMessageType(String input) {
        assertThat(gameLogicHandler.validateAndReturnInput(input)).isEqualTo(ErrorMessages.INPUT_TYPE.getCode());
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "758", "888"})
    public void validateInput_ShouldReturnNumber(String input) {
        assertThat(gameLogicHandler.validateAndReturnInput(input)).isEqualTo(Integer.parseInt(input));
    }

    @RepeatedTest(10)
    public void makeRandomNumberForGame() {
        String randomNumber = String.valueOf(gameLogicHandler.makeRandomNumberForGame());
        System.out.println(randomNumber);
        assertThat(randomNumber)
                .doesNotContain("0")
                .hasSize(3);
    }

}
