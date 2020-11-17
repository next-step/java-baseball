package com.baseball.game.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("스윙 결과판 테스트")
class ResultBoardTest {
    private Pitcher pitcher;
    private Batter batter;

    @BeforeEach
    void init(){
        pitcher = Pitcher.create();
        Batter tempBat = Batter.create(214);
        pitcher.setNumberBox(tempBat.getNumberBox());
    }


    @ParameterizedTest
    @ValueSource(ints = {413})
    @DisplayName("볼->스트라이크 순서이지만, sorting되어 스트라이크부터 출력된다 - 1볼 1스트라이크")
    public void swingResultEmptyNothing(int numbers){
        //given
        batter = Batter.create(numbers);

        //when
        ResultBoard resultBoard = ResultBoard.of(pitcher, batter);

        //then
        assertTrue(resultBoard.toString().contains("1스트라이크 1볼"));
    }

    @ParameterizedTest
    @ValueSource(ints = {492})
    @DisplayName("볼의 카운팅이 중첩된다 - 2볼")
    public void appendBallCount(int numbers){
        //given
        batter = Batter.create(numbers);

        //when
        ResultBoard resultBoard = ResultBoard.of(pitcher, batter);

        //then
        assertTrue(resultBoard.toString().contains("2볼"));
    }

    @ParameterizedTest
    @ValueSource(ints = {389})
    @DisplayName("3낫씽은 공백으로 표기된다")
    public void swingResultAllNothingIsEmpty(int numbers){
        //given
        batter = Batter.create(numbers);

        //when
        ResultBoard resultBoard = ResultBoard.of(pitcher, batter);

        //then
        assertTrue(resultBoard.toString().isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {214})
    @DisplayName("3스트라이크, 아웃")
    public void isStrikeOut(int numbers){
        //given
        batter = Batter.create(numbers);

        //when
        ResultBoard resultBoard = ResultBoard.of(pitcher, batter);

        //then
        assertTrue(resultBoard.toString().contains("3스트라이크"));
        assertTrue(resultBoard.isOut());
    }

    @Test
    public void fasdfdsf(){
        List<Integer> aa = Lists.list(1,2,3);
        System.out.println(aa.toString());
    }
}