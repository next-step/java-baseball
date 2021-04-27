package com.tech.baseball.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameValidatorTest {

    private BaseballGameValidator validator = new BaseballGameValidator();

    @Test
    @DisplayName("숫자가 아닌 경우")
    void checkNumberValid() {
        assertEquals(validator.checkNumberValid("abdc"),false);
        assertEquals(validator.checkNumberValid("13fd"),false);
    }

    @Test
    @DisplayName("3자리 숫자가 아닌 경우")
    void checkNumberValid1() {
        assertEquals(validator.checkNumberValid("15124"),false);
        assertEquals(validator.checkNumberValid("2"),false);
    }

    @Test
    @DisplayName("3자리 숫자인 경우")
    void checkNumberValid2() {
        assertEquals(validator.checkNumberValid("142"),true);
    }

    @Test
    @DisplayName("중복된 숫자")
    void checkDuplicate() {
        assertEquals(validator.checkDuplicate("122"),true);
    }

    @Test
    @DisplayName("중복된 숫자가 아닌 경우")
    void checkDuplicate1() {
        assertEquals(validator.checkDuplicate("123"),false);
    }

    @Test
    @DisplayName("재시작 유무 판단시 1 또는 2 외의 값이 들어온 경우")
    void checkRestartValid() {
        assertEquals(validator.checkRestartValid("3"),false);
    }

    @Test
    @DisplayName("재시작 유무 판단시 1 또는 2 외의 값이 제대로 들어온 경우")
    void checkRestartValid1() {
        assertEquals(validator.checkRestartValid("1"),true);
    }
}