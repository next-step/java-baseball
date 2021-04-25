package com.github.momentjin.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseballNumberMatchResultTest {

    @DisplayName("bundleSize와 strikeCount가 같고, ballCount가 0이면 정답이다.")
    @Test
    void isMatchTest() {

        // given
        BaseballNumberMatchResult result = new BaseballNumberMatchResult(
                3,
                3,
                0
        );

        // then
        assertTrue(result.isMatch());
    }

    @DisplayName("ballCount가 0이 아니면 정답이 아니다")
    @Test
    void isMatchTest2() {

        // given
        BaseballNumberMatchResult result = new BaseballNumberMatchResult(
                3,
                2,
                1
        );

        // then
        assertFalse(result.isMatch());
    }

    @DisplayName("strikeCount와 bundleSize가 다르면 정답이 아니다.")
    @Test
    void isMatchTest3() {

        // given
        BaseballNumberMatchResult result = new BaseballNumberMatchResult(
                3,
                2,
                0
        );

        // then
        assertFalse(result.isMatch());
    }
}