package com.tech.baseball.service;

import com.tech.baseball.vo.BaseballGameResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameServiceTest {

    private static BaseballGameService baseballGameService;
    private static int[] computerNumber;
    private static int[] userNumber;

    @BeforeAll
    static void setUp(){
        baseballGameService = new BaseballGameService();
        computerNumber = new int[]{1,2,3};
        userNumber = new int[]{2,4,3};
        baseballGameService.setComputerGameNumberHashSet(computerNumber);
    }

    @Test
    @DisplayName("Ball 갯수 확인 Computer [1,2,3] User [2,4,3]")
    void getBall() {
        assertEquals(baseballGameService.getBall(computerNumber,userNumber),1);
    }

    @Test
    @DisplayName("Strike 갯수 확인 Computer [1,2,3] User [2,4,3]")
    void getStrike() {
        assertEquals(baseballGameService.getStrike(computerNumber,userNumber),1);
    }

    @Test
    @DisplayName("Result의 Ball/Strike 모두 0인 경우")
    void isNothing() {
        BaseballGameResult result = new BaseballGameResult();
        result.setBall(0);
        result.setStrike(0);
        assertEquals(baseballGameService.isNothing(result),true);
    }

    @Test
    @DisplayName("Result의 Ball/Strike 모두 0이 아닌 경우")
    void isNothing1() {
        BaseballGameResult result = new BaseballGameResult();
        result.setBall(1);
        result.setStrike(2);
        assertEquals(baseballGameService.isNothing(result),false);
    }

    @Test
    @DisplayName("Result의 Strike 3인 경우")
    void isFinish() {
        BaseballGameResult result = new BaseballGameResult();
        result.setBall(0);
        result.setStrike(3);
        assertEquals(baseballGameService.isFinish(result),true);
    }

    @Test
    @DisplayName("Result의 Strike 3이 아닌 경우")
    void isFinish1() {
        BaseballGameResult result = new BaseballGameResult();
        result.setBall(0);
        result.setStrike(1);
        assertEquals(baseballGameService.isFinish(result),false);
    }

    @Test
    @DisplayName("BaseballGameResult 객체로 결과 값 반환 확인")
    void checkBaseballGameResult() {
        BaseballGameResult result = baseballGameService.checkBaseballGameResult(computerNumber,userNumber);
        assertEquals(result.getBall(),1);
        assertEquals(result.getStrike(),1);
    }

}