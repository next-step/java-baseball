package com.woowahan.pro.referee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeImplTest {
    private RefereeImpl referee;

    @BeforeEach
    public void init() {
        referee = new RefereeImpl();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,1", "2,1,0"})
    @DisplayName("스트라이크 판단 검증")
    public void judgeStrike(String opponentNumber, String playerNumber, int expected) {
        try {
            //given
            Method method = referee.getClass().getDeclaredMethod("judgeStrike", String.class, String.class);
            method.setAccessible(true);

            //when
            method.invoke(referee, opponentNumber, playerNumber);

            //then
            assertThat(referee.getStrike()).isEqualTo(expected);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"2,0,1", "2,1,0", "4,1,0"})
    @DisplayName("볼 판단 검증")
    public void judgeBall(String playerNumber, int index, int expected) {
        try {
            //given
            String[] opponentNumbers = new String[]{"1", "2", "3"};
            Method method = referee.getClass().getDeclaredMethod("judgeBall", String[].class, String.class, int.class);
            method.setAccessible(true);

            //when
            method.invoke(referee, opponentNumbers, playerNumber, index);

            //then
            assertThat(referee.getBall()).isEqualTo(expected);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0,0", "2,1,1", "2,0,1", "0,3,1", "0,0,1"})
    @DisplayName("게임 상태값 검증")
    public void getStatus(int strike, int ball, int result) {
        try {
            //given
            GameStatus expected = getGameStatus(result);
            referee = new RefereeImpl(strike, ball);
            Method method = referee.getClass().getDeclaredMethod("getStatus");
            method.setAccessible(true);

            //when
            GameStatus status = (GameStatus)method.invoke(referee);

            //then
            assertThat(status).isEqualTo(expected);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"'1,2,3','1,2,3',0", "'1,2,3','3,2,1',1", "'1,2,3','4,5,6',1"})
    @DisplayName("상대방 숫자들과 플레이어 숫자들을 비교하여 결과 판단(핵심로직)")
    public void judge(String opponentNumbers, String playerNumbers, int result) {
        //given
        GameStatus expected = getGameStatus(result);
        String[] opponentNumberArray = opponentNumbers.split(",");
        String[] playerNumberArray = playerNumbers.split(",");

        //when
        GameStatus status = referee.judge(opponentNumberArray, playerNumberArray);

        //then
        assertThat(status).isEqualTo(expected);
    }

    private GameStatus getGameStatus(int result) {
        if(result == 0) {
            return GameStatus.SUCCESS;
        }
        return GameStatus.FAIL;
    }
}
