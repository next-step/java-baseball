package com.bbidag.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    private Computer computer;

    @BeforeEach
    public void setUp(){
        computer = new Computer(new Random(System.currentTimeMillis()));
    }

    @Test
    @DisplayName("기존 숫자 배열에서 새로 입력된 숫자가 중복되는 숫자가 있는지의 여부 검증 테스트")
    public void hasDuplicateNumber(){
        assertThat(computer.hasDuplicatedNumber(new int[]{3,5,0},1)).isFalse();
        assertThat(computer.hasDuplicatedNumber(new int[]{2,5,6},2)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"100","430","124","256","734","824","521"})
    @DisplayName("배열에 존재하지 않는 숫자를 리턴하는지 테스트")
    public void numberWithoutInArrayNumber(String strNums){
        String[] numArray = strNums.split("");
        int[] numbers = new int[3];
        int idx = 0;
        for(String numStr : numArray){
            numbers[idx++] = Integer.parseInt(numStr);
        }
        int newNumber = computer.numberWithoutDuplicate(numbers);
        assertThat(newNumber).isNotEqualTo(numbers[0]);
        assertThat(newNumber).isNotEqualTo(numbers[1]);
        assertThat(newNumber).isNotEqualTo(numbers[2]);
    }

    @Test
    @DisplayName("3자리 수의 랜덤 배열 생성 테스트")
    public void getRandomNumbersEachExecution(){
        assertThat(computer.generateRandomNumbers().length).isEqualTo(3);
    }

}
