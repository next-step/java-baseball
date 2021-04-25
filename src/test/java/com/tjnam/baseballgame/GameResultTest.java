package com.tjnam.baseballgame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @Test
    public void addStrikeTest(){
        GameResult result = new GameResult();

        assertThat(result.strike).isEqualTo(0);
        result.addStrike();
        assertThat(result.strike).isEqualTo(1);
        result.addStrike();
        assertThat(result.strike).isEqualTo(2);
        result.addStrike();
        assertThat(result.strike).isEqualTo(3);
    }


    @Test
    public void addBallTest(){
        GameResult result = new GameResult();

        assertThat(result.ball).isEqualTo(0);
        result.addBall();
        assertThat(result.ball).isEqualTo(1);
        result.addBall();
        assertThat(result.ball).isEqualTo(2);
        result.addBall();
        assertThat(result.ball).isEqualTo(3);
    }

    @Test
    public void resultStringTest(){
        GameResult result = new GameResult();

        result.strike = 3;
        assertThat(result.getResultString()).isEqualTo("3 스트라이크");

        result.strike = 2;
        result.ball = 1;
        assertThat(result.getResultString()).isEqualTo("2 스트라이크 1 볼");

        result.strike = 1;
        result.ball = 2;
        assertThat(result.getResultString()).isEqualTo("1 스트라이크 2 볼");

        result.strike = 0;
        result.ball = 2;
        assertThat(result.getResultString()).isEqualTo("2 볼");

        result.strike = 0;
        result.ball = 0;
        assertThat(result.getResultString()).isEqualTo("낫싱");
    }

    @Test
    public void threeStrikeJudgeTest(){
        GameResult result = new GameResult();

        result.strike = 3;
        assertThat(result.isThreeStrike()).isTrue();

        result.strike = 2;
        result.ball = 1;
        assertThat(result.isThreeStrike()).isFalse();

        result.strike = 0;
        result.ball = 0;
        assertThat(result.isThreeStrike()).isFalse();

        result.strike = 0;
        result.ball = 2;
        assertThat(result.isThreeStrike()).isFalse();
    }

}
