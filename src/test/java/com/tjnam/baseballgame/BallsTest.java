package com.tjnam.baseballgame;

import org.junit.jupiter.api.Test;

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

}
