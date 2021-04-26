package com.tjnam.baseballgame;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private static final String ballString = "123";
    private static final int[] ballValues = new int[]{1, 2, 3};

    @Test
    public void getRandomNumbersTest(){
        Ball ball = new Ball();

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
        Ball ball = new Ball(ballValues);

        int[] setBalls = ball.getNumbers();
        assertThat(setBalls).isEqualTo(ballValues);

        ball = new Ball();
        ball.setBallValues(ballValues);
        setBalls = ball.getNumbers();
        assertThat(setBalls).isEqualTo(ballValues);

    }

    @Test
    public void setBallByStringTest(){
        Ball ball = new Ball(ballString);

        int[] setBalls = ball.getNumbers();
        assertThat(setBalls).isEqualTo(ballValues);

        ball = new Ball();
        ball.setBallValues(ballString);
        setBalls = ball.getNumbers();
        assertThat(setBalls).isEqualTo(ballValues);
    }


    @Test
    public void compareBallsTest(){
        Ball dealerBall = new Ball("123");
        Ball userBall = new Ball();
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
        userBall.setBallValues("179");
        comparedResult = dealerBall.compareBalls(userBall);
        assertThat(comparedResult.strike).isEqualTo(0);
        assertThat(comparedResult.ball).isEqualTo(1);
    }


    @Test
    public void markBallValuesTest(){
        Ball ball = new Ball("123");
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
        Ball ball = new Ball("123");
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
    public void setRandomBallsTest(){
        Ball ball = new Ball();
        ball.setRandomBalls();

        try {
            Field ballValuesAttribute = ball.getClass().getDeclaredField("ballValues");
            ballValuesAttribute.setAccessible(true);

            int[] ballValue = (int[])ballValuesAttribute.get(ball);
            assertThat(ballValue.length).isEqualTo(3);
            assertThat(ballValue[0]).isNotEqualTo(ballValue[1]);
            assertThat(ballValue[1]).isNotEqualTo(ballValue[2]);
            assertThat(ballValue[0]).isNotEqualTo(ballValue[2]);

            assertThat(ballValue[0]).isGreaterThan(0)
                    .isLessThan(10);
            assertThat(ballValue[1]).isGreaterThan(0)
                    .isLessThan(10);
            assertThat(ballValue[2]).isGreaterThan(0)
                    .isLessThan(10);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
