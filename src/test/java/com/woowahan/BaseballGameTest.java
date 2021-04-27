package com.woowahan;

import com.woowahan.service.BaseballGameService;
import com.woowahan.vo.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballGameTest {

    @Test
    @DisplayName("컴퓨터 수 가져오기")
    public void computerSetTest(){
        // given
        // when
        LinkedHashSet<Integer> computerSet = BaseballGameService.getComputerSet();
        // then
        assertEquals(3, computerSet.size());
    }

    @Test
    @DisplayName("플레이어 입력값 체크")
    public void validateInput(){
        // given
        Result result = new Result();
        Set<Integer> playerSet = new LinkedHashSet<>();
        String[] input = {"1", "2", "3"};
        // when
        boolean validateInput = BaseballGameService.validateInput(playerSet, input);

        // then
        assertFalse(validateInput);
    }

    @Test
    @DisplayName("볼 카운트 체크")
    public void getScore(){
        // given
        Result result = new Result();

        // when
        BaseballGameService.getScore(1, 1, result);

        // then
        assertEquals(0, result.getBall());
        assertEquals(1, result.getStrike());
    }

    @Test
    @DisplayName("컴퓨터 수와 상대수 비교")
    public void getPlayerSetTest(){
        // given
        Set<Integer> computerSet = new LinkedHashSet<>();
        computerSet.add(1);
        computerSet.add(2);
        computerSet.add(3);
        Set<Integer> playerSet = new LinkedHashSet<>();
        playerSet.add(3);
        playerSet.add(1);
        playerSet.add(4);
        BaseballGame.computerSet = computerSet;

        // when
        Result result = BaseballGameService.calculateScore(playerSet);

        // then
        assertEquals(2, result.getBall());
        assertEquals(0, result.getStrike());
    }

    @Test
    @DisplayName("스트라이크 체크 실패")
    public void checkStrikeFail(){
        // given
        // when
        boolean isAlltrike = BaseballGameService.checkAllStrike(1);
        // then
        assertFalse(isAlltrike);
    }

    @Test
    @DisplayName("스트라이크 체크 성공")
    public void checkStrikeSuccess(){
        // given
        // when
        boolean isAlltrike = BaseballGameService.checkAllStrike(3);
        // then
        assertTrue(isAlltrike);
    }
}