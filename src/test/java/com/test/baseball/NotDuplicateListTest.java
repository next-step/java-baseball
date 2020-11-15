package com.test.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class NotDuplicateListTest {
    private NotDuplicateList list;

    @BeforeEach
    public void init(){
        list = new NotDuplicateList(3);
    }

    @Test
    public void testAdd(){
        list.add(1);
        list.add(1);

        assertThat(list.size()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,true", "1,1,3,false"})
    public void testIsFull(int num1, int num2, int num3, boolean expected){
        list.add(num1);
        list.add(num2);
        list.add(num3);

        assertThat(list.isFull()).isEqualTo(expected);
    }
}
