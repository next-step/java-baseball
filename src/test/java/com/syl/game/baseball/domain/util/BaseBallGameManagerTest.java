package com.syl.game.baseball.domain.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseBallGameManagerTest {

    @Test
    public void getInstanceTest() {
        // 1. 객체가 만들어졌는지 확인.
        //Given
        BaseBallGameManager baseBallGameManager = null;

        //When
        baseBallGameManager = BaseBallGameManager.getInstance();

        //Then
        assertNotNull(baseBallGameManager);

        // 2. 객체가 유일한지 확인
        //Given
        BaseBallGameManager baseBallGameManager2 = null;

        //When
        baseBallGameManager2 = BaseBallGameManager.getInstance();

        //Then
        assertSame(baseBallGameManager, baseBallGameManager2);

    }

    @Test
    void judgeStrikeOrBallOrNothingTest() {

    }

    @Test
    void getCurrentPlayerTest() {

    }

    @Test
    void setCurrentPlayerTest() {

    }
}