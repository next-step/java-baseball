package com.nextstep.baseball.handler;

import com.nextstep.baseball.enums.ErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource("provideSourceAndTargetNumber_3Strike")
    public void checkStrike_3Strike(int source, int target) {
        assertThat(gameLogicHandler.checkStrike(source, target))
                .isEqualTo(3);
    }

    private static Stream<Arguments> provideSourceAndTargetNumber_3Strike() {
        return Stream.of(
                Arguments.of(123, 123),
                Arguments.of(321, 321),
                Arguments.of(438, 438),
                Arguments.of(256, 256)
        );
    }

    @ParameterizedTest
    @MethodSource("provideSourceAndTargetNumber_2Strike")
    public void checkStrike_2Strike(int source, int target) {
        assertThat(gameLogicHandler.checkStrike(source, target))
                .isEqualTo(2);
    }

    private static Stream<Arguments> provideSourceAndTargetNumber_2Strike() {
        return Stream.of(
                Arguments.of(387, 385),
                Arguments.of(492, 392),
                Arguments.of(598, 198)
        );
    }

    @ParameterizedTest
    @MethodSource("provideSourceAndTargetNumber_1Strike")
    public void checkStrike_1Strike(int source, int target) {
        assertThat(gameLogicHandler.checkStrike(source, target))
                .isEqualTo(1);
    }

    private static Stream<Arguments> provideSourceAndTargetNumber_1Strike() {
        return Stream.of(
                Arguments.of(123, 156),
                Arguments.of(251, 358),
                Arguments.of(842, 941)
        );
    }
}
