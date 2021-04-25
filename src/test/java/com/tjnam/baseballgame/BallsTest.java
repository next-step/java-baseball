package com.tjnam.baseballgame;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    private static String ballString = "123";
    private static int[] ballValues = new int[]{1, 2, 3};

    @Test
    public void getRandomNumbersTest(){
        Balls ball = new Balls();

        try{
            Method getRandomNumbersMethod = ball.getClass().getDeclaredMethod("getRandomNumbers");
            getRandomNumbersMethod.setAccessible(true);

            int[] randomNumbers = (int[]) getRandomNumbersMethod.invoke(ball);

            assertThat(randomNumbers.length).isEqualTo(3);

            assertThat(randomNumbers[0]).isPositive()
                    .isGreaterThan(0)
                    .isLessThan(10);

            assertThat(randomNumbers[1]).isPositive()
                    .isGreaterThan(0)
                    .isLessThan(10);

            assertThat(randomNumbers[2]).isPositive()
                    .isGreaterThan(0)
                    .isLessThan(10);

            assertThat(randomNumbers[0]).isNotEqualTo(randomNumbers[1]);
            assertThat(randomNumbers[1]).isNotEqualTo(randomNumbers[2]);
            assertThat(randomNumbers[0]).isNotEqualTo(randomNumbers[2]);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setBallByIntArrayTest(){
        Balls ball = new Balls(ballValues);

        int[] setBalls = ball.getNumbers();
        assertThat(setBalls).isEqualTo(ballValues);

        ball = new Balls();
        ball.setBallValues(ballValues);
        setBalls = ball.getNumbers();
        assertThat(setBalls).isEqualTo(ballValues);

    }

    @Test
    public void setBallByStringTest(){
        Balls ball = new Balls(ballString);

        int[] setBalls = ball.getNumbers();
        assertThat(setBalls).isEqualTo(ballValues);

        ball = new Balls();
        ball.setBallValues(ballString);
        setBalls = ball.getNumbers();
        assertThat(setBalls).isEqualTo(ballValues);
    }


    @Test
    public void compareBallsTest(){
        Balls dealerBall = new Balls("123");
        Balls userBall = new Balls();
        userBall.setBallValues("132");

        GameResult comparedResult = dealerBall.compareBalls(userBall);

        assertThat(comparedResult.strike).isEqualTo(1);
        assertThat(comparedResult.ball).isEqualTo(2);

        //0s 0b
        userBall.setBallValues("444");
        comparedResult = dealerBall.compareBalls(userBall);
        assertThat(comparedResult.strike).isEqualTo(0);
        assertThat(comparedResult.ball).isEqualTo(0);

        userBall.setBallValues("312");
        comparedResult = dealerBall.compareBalls(userBall);
        assertThat(comparedResult.strike).isEqualTo(0);
        assertThat(comparedResult.ball).isEqualTo(3);

        userBall.setBallValues("144");
        comparedResult = dealerBall.compareBalls(userBall);
        assertThat(comparedResult.strike).isEqualTo(1);
        assertThat(comparedResult.ball).isEqualTo(0);

        userBall.setBallValues("309");
        comparedResult = dealerBall.compareBalls(userBall);
        assertThat(comparedResult.strike).isEqualTo(0);
        assertThat(comparedResult.ball).isEqualTo(1);

        dealerBall.setBallValues("381");
        userBall.setBallValues("189");
        comparedResult = dealerBall.compareBalls(userBall);
        assertThat(comparedResult.strike).isEqualTo(0);
        assertThat(comparedResult.ball).isEqualTo(1);
    }


    @Test
    public void markBallValuesTest(){
        Balls ball = new Balls("123");
        Boolean[] valueMarking;

        try {
            Field ballExistMarkVariable = ball.getClass().getDeclaredField("ballExists");
            ballExistMarkVariable.setAccessible(true);

            valueMarking = (Boolean[])ballExistMarkVariable.get(ball);
            assertThat(valueMarking[0]).isFalse();
            assertThat(valueMarking[4]).isFalse();
            assertThat(valueMarking[5]).isFalse();
            assertThat(valueMarking[6]).isFalse();
            assertThat(valueMarking[7]).isFalse();
            assertThat(valueMarking[8]).isFalse();
            assertThat(valueMarking[9]).isFalse();

            assertThat(valueMarking[1]).isTrue();
            assertThat(valueMarking[2]).isTrue();
            assertThat(valueMarking[3]).isTrue();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void isExistValueOnBallsTest(){
        Balls ball = new Balls("123");
        Boolean[] valueMarking;

        try {
            Field ballExistMarkVariable = ball.getClass().getDeclaredField("ballExists");
            ballExistMarkVariable.setAccessible(true);

            valueMarking = (Boolean[])ballExistMarkVariable.get(ball);
            assertThat(valueMarking[0]).isFalse();
            assertThat(valueMarking[4]).isFalse();
            assertThat(valueMarking[5]).isFalse();
            assertThat(valueMarking[6]).isFalse();
            assertThat(valueMarking[7]).isFalse();
            assertThat(valueMarking[8]).isFalse();
            assertThat(valueMarking[9]).isFalse();

            assertThat(valueMarking[1]).isTrue();
            assertThat(valueMarking[2]).isTrue();
            assertThat(valueMarking[3]).isTrue();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
