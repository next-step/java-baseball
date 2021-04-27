package com.syl.game.baseball.domain.player;

import com.syl.game.baseball.domain.entity.BaseBallJudgementStatus;
import com.syl.game.baseball.domain.entity.BaseBallNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseBallMachineTest {

    private BaseBallNumbers machineNumbers;
    private BaseBallNumbers oneStrikeNumbers;
    private BaseBallNumbers threeStrikeNumbers;
    private BaseBallNumbers oneBallNumbers;
    private BaseBallNumbers threeBallNumbers;
    private BaseBallNumbers nothingNumbers;

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
    public void generateRandomNumbersTest() {
        BaseBallMachine baseBallMachine = new BaseBallMachine();
        BaseBallNumbers baseBallNumbers = baseBallMachine.GenerateRandomNumbers();
        int first = baseBallNumbers.getFirst();
        int second = baseBallNumbers.getSecond();
        int third = baseBallNumbers.getThird();
        assertTrue(1 <= first && first <= 9);
        assertTrue(1 <= second && second <= 9);
        assertTrue(1 <= third && third <= 9);
    }

    @Test
    void selectThreeNumbersTest() {
        BaseBallMachine baseBallMachine = new BaseBallMachine();
        BaseBallNumbers baseBallNumbers = baseBallMachine.selectThreeNumbers();
        int first = baseBallNumbers.getFirst();
        int second = baseBallNumbers.getSecond();
        int third = baseBallNumbers.getThird();
        assertTrue(1 <= first && first <= 9);
        assertTrue(1 <= second && second <= 9);
        assertTrue(1 <= third && third <= 9);
    }

    @Test
    public void judgeStrikeOrBallOrNothingTest() {
        BaseBallMachine baseBallMachine = new BaseBallMachine();
        BaseBallJudgementStatus baseBallJudgementStatus = baseBallMachine.judgeStrikeOrBallOrNothing(machineNumbers, threeStrikeNumbers);
        assertSame(3, baseBallJudgementStatus.getStrike());
    }

    @Test
    public void T01_1스트라이크_판정() {
        //Given
        BaseBallMachine baseBallMachine = new BaseBallMachine();

        //When
        BaseBallJudgementStatus baseBallJudgementStatus = baseBallMachine.judgeStrikeOrBallOrNothing(machineNumbers, oneStrikeNumbers);

        //Then
        assertSame(1, baseBallJudgementStatus.getStrike());
    }

    @Test
    public void T02_3스트라이크_판정() {
        //Given
        BaseBallMachine baseBallMachine = new BaseBallMachine();

        //When
        BaseBallJudgementStatus baseBallJudgementStatus = baseBallMachine.judgeStrikeOrBallOrNothing(machineNumbers, threeStrikeNumbers);

        //Then
        assertSame(3, baseBallJudgementStatus.getStrike());
    }

    @Test
    public void T03_1볼_판정() {
        //Given
        BaseBallMachine baseBallMachine = new BaseBallMachine();

        //When
        BaseBallJudgementStatus baseBallJudgementStatus = baseBallMachine.judgeStrikeOrBallOrNothing(machineNumbers, oneBallNumbers);

        //Then
        assertSame(1, baseBallJudgementStatus.getBall());
    }

    @Test
    public void T04_3볼_판정() {
        //Given
        BaseBallMachine baseBallMachine = new BaseBallMachine();

        //When
        BaseBallJudgementStatus baseBallJudgementStatus = baseBallMachine.judgeStrikeOrBallOrNothing(machineNumbers, threeBallNumbers);

        //Then
        assertSame(3, baseBallJudgementStatus.getBall());
    }

    @Test
    public void T05_4볼_판정() {
        //Given
        BaseBallMachine baseBallMachine = new BaseBallMachine();

        //When
        BaseBallJudgementStatus baseBallJudgementStatus = baseBallMachine.judgeStrikeOrBallOrNothing(machineNumbers, nothingNumbers);

        //Then
        assertSame(3, baseBallJudgementStatus.getNothing());
    }

}