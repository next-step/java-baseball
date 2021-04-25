package com.github.momentjin.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerInputValidatorTest {

    PlayerInputValidator validator = new PlayerInputValidator();

    @Test
    void isNotNumber() {

        // given
        String inputNumbers = "12a";

        // when
        ValidatorResult result = validator.isNotNumber(inputNumbers);

        // then
        assertTrue(result.isError());
    }

    @Test
    void isInvalidSize() {

        // given
        String inputNumbers = "1234";

        // when
        ValidatorResult result = validator.isInvalidSize(inputNumbers, 3);

        // then
        assertTrue(result.isError());
    }

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