package com.ascii92der.baseball.game;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {
    private Computer computer;

    @Test
    public void isContainedNumberTest() {
        computer = new Computer();
        List<Integer> numberList = computer.generateNumbers();
        assertThat(numberList).size().isEqualTo(3);
    }

    @Test
    public void generateNumbersTest() {
        computer = new Computer();
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(3);
        numberList.add(2);
        assertThat(computer.isContainedNumber(numberList,1)).isTrue();
    }
}
