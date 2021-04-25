package com.baseball.precourse.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @DisplayName("Game - Ball 생성")
    @Test
    void gameBallTest(){
        // given
        String userInputString = new String("123");
        Game game = new Game(()-> {
            return userInputString;
        });

        // when
        Ball ball = game.chooseBall();

        // then
        assertThat(ball).isEqualTo(new Ball(userInputString));
    }

    @DisplayName("Game - 게임 종료")
    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:true", "3:false"}, delimiter = ':')
    void isOverGameTest(String userInput, String expectedResult){
        // given
        Game game = new Game(()-> {
            return userInput;
        });

        // when
        boolean isOver= game.isOver();

        // then
        assertThat(isOver).isEqualTo(Boolean.parseBoolean(expectedResult));
    }
}
