package com.baseball.precourse.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @DisplayName("Play")
    @ParameterizedTest
    @CsvSource(value = {"123:123:3 스트라이크", "111:123:1 스트라이크", "321:123:1 스트라이크 2 볼", "123:312:3 볼"}, delimiter = ':')
    void hitTest(String ballInput, String playerInput, String expectedText){
        // given
        Ball ball = new Ball(ballInput);
        Player player = new Player(playerInput);

        // when
        Score score = player.hit(ball);

        // then
        assertThat(score.toString()).isEqualTo(expectedText);
    }
}
