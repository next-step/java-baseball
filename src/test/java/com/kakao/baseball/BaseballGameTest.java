package com.kakao.baseball;

import static org.assertj.core.api.Assertions.*;

import com.kakao.baseball.game.BaseballGame;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * baseballgame의 단위 테스트
 */
public class BaseballGameTest {
    private BaseballGameMock baseballGame;
    private int num;
    @BeforeEach
    public void setUp() {
        baseballGame = new BaseballGameMock();
    }

    @ParameterizedTest
    @CsvSource({"123,true","100,false","-100,false","111,false"})
    public void validateTest(int input, boolean result){
        assertThat(baseballGame.validateInput(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"234,2 볼","678,낫싱","123,3개의 숫자를 모두 맞히셨습니다! 게임 종료"})
    public void checkTest(int input, String result){
        baseballGame.checkUserInput(input);
        assertThat(baseballGame.getResult()).contains(result);
    }

    @ParameterizedTest
    @CsvSource({"234,1 볼","178,낫싱","456,3개의 숫자를 모두 맞히셨습니다! 게임 종료"})
    public void checkTestAfterInit(int input, String result){
        baseballGame.initBaseballNumber();
        baseballGame.checkUserInput(input);
        assertThat(baseballGame.getResult()).contains(result);
    }

}
