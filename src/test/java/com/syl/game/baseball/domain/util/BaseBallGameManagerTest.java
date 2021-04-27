package com.syl.game.baseball.domain.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.syl.game.baseball.domain.entity.*;

import static org.junit.jupiter.api.Assertions.*;

public class BaseBallGameManagerTest {
    private BaseBallNumbers machineNumbers;
    private BaseBallNumbers oneStrikeNumbers;
    private BaseBallNumbers threeStrikeNumbers;
    private BaseBallNumbers oneBallNumbers;
    private BaseBallNumbers threeBallNumbers;
    private BaseBallNumbers nothingNumbers;
    private BaseBallGameManager baseBallGameManager;


    @BeforeEach
    public void setUp() {
        machineNumbers = new BaseBallNumbers(123);
        threeStrikeNumbers = new BaseBallNumbers(123);
        oneStrikeNumbers = new BaseBallNumbers(145);
        oneBallNumbers = new BaseBallNumbers(415);
        threeBallNumbers = new BaseBallNumbers(312);
        nothingNumbers = new BaseBallNumbers(456);
    }

    @Test
    public void T01_1스트라이크_판정() {
        //Given
        baseBallGameManager = new BaseBallGameManager();

        //When
        BaseBallJudgementStatus baseBallJudgementStatus = baseBallGameManager.judgeStrikeOrBallOrNothing(machineNumbers, oneStrikeNumbers);

        //Then
        assertSame(1, baseBallJudgementStatus.getStrike());
    }

    @Test
    public void T02_3스트라이크_판정() {
        //Given
        baseBallGameManager = new BaseBallGameManager();

        //When
        BaseBallJudgementStatus baseBallJudgementStatus = baseBallGameManager.judgeStrikeOrBallOrNothing(machineNumbers, threeStrikeNumbers);

        //Then
        assertSame(3, baseBallJudgementStatus.getStrike());
    }

    @Test
    public void T03_1볼_판정() {
        //Given
        baseBallGameManager = new BaseBallGameManager();

        //When
        BaseBallJudgementStatus baseBallJudgementStatus = baseBallGameManager.judgeStrikeOrBallOrNothing(machineNumbers, oneBallNumbers);

        //Then
        assertSame(1, baseBallJudgementStatus.getBall());
    }

    @Test
    public void T04_3볼_판정() {
        //Given
        baseBallGameManager = new BaseBallGameManager();

        //When
        BaseBallJudgementStatus baseBallJudgementStatus = baseBallGameManager.judgeStrikeOrBallOrNothing(machineNumbers, threeBallNumbers);

        //Then
        assertSame(3, baseBallJudgementStatus.getBall());
    }

    @Test
    public void T05_4볼_판정() {
        //Given
        baseBallGameManager = new BaseBallGameManager();

        //When
        BaseBallJudgementStatus baseBallJudgementStatus = baseBallGameManager.judgeStrikeOrBallOrNothing(machineNumbers, nothingNumbers);

        //Then
        assertSame(3, baseBallJudgementStatus.getNothing());
    }
}