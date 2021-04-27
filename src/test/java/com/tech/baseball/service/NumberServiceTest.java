package com.tech.baseball.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberServiceTest {

    private NumberService numberService = new NumberService();

    @Test
    @DisplayName("3가지 숫자 입력 시 파싱")
    void parseUserNumber() {
        assertArrayEquals(numberService.parseUserNumber("123"),new int[]{1,2,3});
    }

    @Test
    @DisplayName("3자리 숫자 생성")
    void makeComputerGameNumber() {
        assertEquals(numberService.makeComputerGameNumber().length,3);
    }

}