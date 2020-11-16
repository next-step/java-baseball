package com.coderhglee.game.domain;

import com.coderhglee.game.baseball.BaseballGame;
import com.coderhglee.game.exception.GameException;
import com.coderhglee.game.number.UserInputNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class BaseballGameStatusTest {

    private BaseballGame baseballGame;

    @BeforeEach
    void setUp() throws GameException {
        baseballGame = new BaseballGame(new UserInputNumber("321"));
    }

    @DisplayName("사용자 예측한 야구게임 결과의 상태 메세지가 일치 하는가")
    @ParameterizedTest
    @MethodSource("playBaseballGameExactedResult")
    void isEqualsGameStatus(String input, String expectedMessageForUser) throws GameException {
        baseballGame.gameProcess(new UserInputNumber(input));
        assertThat(baseballGame.getGameResultMessage()).isEqualTo(expectedMessageForUser);
    }

    public static Stream<Arguments> playBaseballGameExactedResult() {
        return Stream.of(
                Arguments.of("123", "1 스트라이크 2볼"),
                Arguments.of("291", "1 스트라이크 1볼"),
                Arguments.of("891", "1 스트라이크"),
                Arguments.of("456", "낫싱"),
                Arguments.of("321", "3개의 숫자를 모두 맞히셨습니다!")
        );
    }
}
