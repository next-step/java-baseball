package com.pavlo.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseballGameTest {

    BaseballGame game = new BaseballGame();

    @Test
    @DisplayName("자동생성된 난수값 길이 확인")
    void isComputerNumLength_3() {
        for (int i = 0; i < 100; i++) {
            String numString = game.makeComputerNumString();
            assertEquals(3, numString.length());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"3","32","456a","!312","z789"})
    @DisplayName("사용자 입력값이 유효하지 않은 값인지 확인")
    void isInValidTypePlayerInput(String input){
        assertEquals(true, game.isInvalidInput(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"123:123:3","341:321:2","517:534:1","891:123:0"},delimiter = ':')
    @DisplayName("스트라이크의 개수 값이 정확한지 확인")
    void checkStrikeCount(String computer, String player, String cnt){
        assertEquals(Integer.parseInt(cnt),game.getStrikeCount(computer,player));
    }

    @ParameterizedTest
    @CsvSource(value = {"312:123:3","341:321:0","517:534:0","891:123:1"},delimiter = ':')
    @DisplayName("볼의 개수 값이 정확한지 확인")
    void checkBallCount(String computer, String player, String cnt){
        assertEquals(Integer.parseInt(cnt),game.getBallCount(computer,player));
    }

}