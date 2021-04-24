package com.nextstep.ppyong.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckMatchNumberServiceTest {

    @Test
    @DisplayName("스트라이크 테스트")
    void strikeSuccessTest() {
        CheckMatchNumberService checkMatchNumberService = new CheckMatchNumberService("123");
        assertTrue(checkMatchNumberService.valid("123"));
    }

    @Test
    @DisplayName("1볼 1스트라이크 테스트")
    void oneBallAndOneStrikeExceptionTest() {
        CheckMatchNumberService checkMatchNumberService = new CheckMatchNumberService("123");
        assertThatThrownBy(() -> {
            checkMatchNumberService.valid("134");
        }).isInstanceOf(RuntimeException.class).hasMessageContainingAll("1 볼", "1 스트라이크");
    }

    @Test
    @DisplayName("낫띵 테스트")
    void nothingExceptionTest() {
        CheckMatchNumberService checkMatchNumberService = new CheckMatchNumberService("123");
        assertThatThrownBy(() -> {
            checkMatchNumberService.valid("456");
        }).isInstanceOf(RuntimeException.class).hasMessage("");
    }
}
