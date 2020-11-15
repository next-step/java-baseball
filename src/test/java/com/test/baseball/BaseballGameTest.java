package com.test.baseball;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {
    @Test
    public void testCreateRandomNumbers(){
        BaseballGame game = new BaseballGame();
        Method method;
        List<Integer> numbers = null;

        try{
            method = game.getClass().getDeclaredMethod("createRandomNumbers");
            method.setAccessible(true);
            numbers = (List<Integer>)method.invoke(game);
        } catch ( NoSuchMethodException | IllegalAccessException | InvocationTargetException ignore ) {}

        assertThat(numbers).isNotNull();
        assertThat(numbers.size()).isEqualTo(3);
    }
}
