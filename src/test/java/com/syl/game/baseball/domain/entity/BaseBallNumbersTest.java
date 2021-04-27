package com.syl.game.baseball.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseBallNumbersTest {

    @Test
    public void baseBallNumberConstructorTest() {
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers(123);

        assertEquals(1, baseBallNumbers.getFirst());
        assertEquals(2, baseBallNumbers.getSecond());
        assertEquals(3, baseBallNumbers.getThird());

        baseBallNumbers = new BaseBallNumbers(111);

        assertEquals(0, baseBallNumbers.getFirst());
        assertEquals(0, baseBallNumbers.getSecond());
        assertEquals(0, baseBallNumbers.getThird());

        baseBallNumbers = new BaseBallNumbers(121);

        assertEquals(0, baseBallNumbers.getFirst());
        assertEquals(0, baseBallNumbers.getSecond());
        assertEquals(0, baseBallNumbers.getThird());


        baseBallNumbers = new BaseBallNumbers(223);

        assertEquals(2, baseBallNumbers.getFirst());
        assertEquals(0, baseBallNumbers.getSecond());
        assertEquals(3, baseBallNumbers.getThird());


        baseBallNumbers = new BaseBallNumbers(366);

        assertEquals(3, baseBallNumbers.getFirst());
        assertEquals(6, baseBallNumbers.getSecond());
        assertEquals(0, baseBallNumbers.getThird());


        baseBallNumbers = new BaseBallNumbers(363);

        assertEquals(3, baseBallNumbers.getFirst());
        assertEquals(6, baseBallNumbers.getSecond());
        assertEquals(0, baseBallNumbers.getThird());
    }
}