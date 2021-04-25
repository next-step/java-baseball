package com.baseball.precourse.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {
    @DisplayName("Score - 0 스트라이크 0 볼 경우")
    @Test
    void displayNothingCountTest(){
        // given
        Score score = new Score(0, 0);

        // when
        String displayText = score.toString();

        // then
        assertThat(displayText).isEqualTo("낫싱");
    }

    @DisplayName("Score - 스트라이크 볼 조합의 경")
    @ParameterizedTest
    @CsvSource(value = {"1:0:1 스트라이크", "2:0:2 스트라이크", "1:1:1 스트라이크 1 볼", "0:3:3 볼"}, delimiter = ':')
    void displayScoreCountTest(String strike, String ball, String expectedText){
        // given
        Score score = new Score(Integer.parseInt(strike), Integer.parseInt(ball));

        // when
        String displayText = score.toString();

        // then
        assertThat(displayText).isEqualTo(expectedText);
    }

    @DisplayName("Score - 아웃 체")
    @Test
    void isOutTest(){
        // given
        Score score = new Score(3, 0);

        // when
        boolean isOut = score.isOut();

        // then
        assertThat(isOut).isEqualTo(true);
    }
}
