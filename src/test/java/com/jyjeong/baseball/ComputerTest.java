package com.jyjeong.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    Computer computer = new Computer();

    @Test
    @DisplayName("랜덤한 숫자 3가지 생성 테스트")
    void createRandom() {
        //given
        int[] num;

        //when
        num = computer.CreateRandom();

        //then
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}