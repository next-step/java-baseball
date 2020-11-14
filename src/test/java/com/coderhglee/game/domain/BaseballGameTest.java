package com.coderhglee.game.domain;

import com.coderhglee.game.exception.GameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class BaseballGameTest {

    private BaseballGame baseballGame;

    @BeforeEach
    void setUp() throws GameException {
        baseballGame = new BaseballGame(new UserInputNumber("321"));
    }

    @DisplayName("사용자가 야구게임을 진행하는데 답변에 따른 상태 메세지가 정상적으로 리턴되는가")
    @ValueSource(strings = {"123", "321", "985", "184"})
    @ParameterizedTest
    void baseballGameReturnSuccessMessage(String input) throws GameException {
        assertThat(baseballGame.play(new UserInputNumber(input)).getClass()).isEqualTo(BaseballGameStatus.class);
    }


    @DisplayName("사용자 예측한 야구게임 결과의 상태 메세지가 일치 하는가")
    @ParameterizedTest
    @MethodSource("playBaseballGameExactedResult")
    void isEqualsGameStatus(String input, BaseballGameStatus expectedStatus) throws GameException {
        assertThat(baseballGame.play(new UserInputNumber(input))).isEqualTo(expectedStatus);
    }

    public static Stream<Arguments> playBaseballGameExactedResult() {
        return Stream.of(
                Arguments.of("123", BaseballGameStatus.RETRY),
                Arguments.of("291", BaseballGameStatus.RETRY),
                Arguments.of("891", BaseballGameStatus.RETRY),
                Arguments.of("456", BaseballGameStatus.NOTING),
                Arguments.of("321", BaseballGameStatus.WIN)
        );
    }
}
