package com.test.baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballUserTest {
    @ParameterizedTest
    @CsvSource({"123,false", "1234,true", "122,true", "12,true"})
    public void testEnterNumbers(String source, boolean isNullable){
        BaseballUser user = new BaseballUser(new ByteArrayInputStream(source.getBytes()));
        Method method;
        List<Integer> result = null;

        try{
            method = user.getClass().getDeclaredMethod("enterNumbers");
            method.setAccessible(true);
            result = (List<Integer>)method.invoke(user);
        } catch ( NoSuchMethodException | IllegalAccessException | InvocationTargetException ignore ) {}

        if ( isNullable ) {
            assertThat(result).isNull();
            return;
        }
        assertThat(result).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"123,false","113,true","122,true","313,true"})
    public void testParseNumbers(String source, boolean isNullable){
        BaseballUser user = new BaseballUser();
        Method method;
        List<Integer> result = null;

        try{
            method = user.getClass().getDeclaredMethod("parseNumbers", String.class);
            method.setAccessible(true);
            result = (List<Integer>)method.invoke(user, source);
        } catch ( NoSuchMethodException | IllegalAccessException | InvocationTargetException ignore ) {}

        if ( isNullable ) {
            assertThat(result).isNull();
            return;
        }
        assertThat(result).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,false", "1,2,2,true"})
    public void testIsDuplicate(int num1, int num2, int num3, boolean expected){
        BaseballUser user = new BaseballUser();
        NotDuplicateList list = new NotDuplicateList(3);
        Method method;
        Boolean result = null;

        list.add(num1);
        list.add(num2);
        list.add(num3);

        try{
            method = user.getClass().getDeclaredMethod("isDuplicate", NotDuplicateList.class);
            method.setAccessible(true);
            result = (boolean)method.invoke(user, list);
        } catch ( NoSuchMethodException | IllegalAccessException | InvocationTargetException ignore ) {}

        assertThat(result).isNotNull().isEqualTo(expected);
    }
}
