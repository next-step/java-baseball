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
        machineNumbers = new BaseBallNumbers();
        machineNumbers.setFirst(1);
        machineNumbers.setSecond(2);
        machineNumbers.setThird(3);

        threeStrikeNumbers = new BaseBallNumbers();
        threeStrikeNumbers.setFirst(1);
        threeStrikeNumbers.setSecond(2);
        threeStrikeNumbers.setThird(3);

        oneStrikeNumbers = new BaseBallNumbers();
        oneStrikeNumbers.setFirst(1);
        oneStrikeNumbers.setSecond(4);
        oneStrikeNumbers.setThird(5);

        oneBallNumbers = new BaseBallNumbers();
        oneBallNumbers.setFirst(4);
        oneBallNumbers.setSecond(1);
        oneBallNumbers.setThird(5);

        threeBallNumbers = new BaseBallNumbers();
        threeBallNumbers.setFirst(3);
        threeBallNumbers.setSecond(1);
        threeBallNumbers.setThird(2);

        nothingNumbers = new BaseBallNumbers();
        nothingNumbers.setFirst(4);
        nothingNumbers.setSecond(5);
        nothingNumbers.setThird(6);
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