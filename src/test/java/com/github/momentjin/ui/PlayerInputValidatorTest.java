package com.github.momentjin.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerInputValidatorTest {

    PlayerInputValidator validator = new PlayerInputValidator();

    @DisplayName("입력에 숫자가 아닌 값이 입력되면 isError는 true를 반환한다")
    @Test
    void isNotNumber() {

        // given
        String inputNumbers = "12a";

        // when
        ValidatorResult result = validator.isNotNumber(inputNumbers);

        // then
        assertTrue(result.isError());
    }

    @DisplayName("입력된 숫자 길이가 맞지 않으면, isError는 true를 반환한다")
    @Test
    void isInvalidSize() {

        // given
        String inputNumbers = "1234";

        // when
        ValidatorResult result = validator.isInvalidSize(inputNumbers, 3);

        // then
        assertTrue(result.isError());
    }

    @DisplayName("중복된 숫자를 입력하면, isError는 true를 반환한다")
    @Test
    void containsOverlappedNumber() {

        // given
        String inputNumbers = "122";

        // when
        ValidatorResult result = validator. containsOverlappedNumber(inputNumbers);

        // then
        assertTrue(result.isError());
    }
}