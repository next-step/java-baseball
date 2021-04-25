package com.github.momentjin.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberBundleTest {

    @DisplayName("입력으로 주어진 ball이 Bundle 내 포함되고, 같은 자리이면 strike")
    @Test
    void strikeTest() {

        // given
        BaseballNumberBundle origin = new BaseballNumberBundle(Arrays.asList(
                new BaseballNumber(7),
                new BaseballNumber(1),
                new BaseballNumber(3)
        ));

        BaseballNumber number = new BaseballNumber(7);

        // when
        boolean isStrike = origin.isStrike(0, number);
        boolean isBall = origin.isBall(0, number);

        // then
        assertTrue(isStrike);
        assertFalse(isBall);
    }

    @DisplayName("입력으로 주어진 ball이 Bundle 내 포함되지만, 다른 인덱스이면 ball")
    @Test
    void ballTest() {

        // given
        BaseballNumberBundle origin = new BaseballNumberBundle(Arrays.asList(
                new BaseballNumber(7),
                new BaseballNumber(1),
                new BaseballNumber(3)
        ));

        BaseballNumber number = new BaseballNumber(7);

        // when
        boolean isStrike = origin.isStrike(2, number);
        boolean isBall = origin.isBall(2, number);

        // then
        assertFalse(isStrike);
        assertTrue(isBall);
    }

    @DisplayName("입력으로 주어진 ball이 Bundle 내 포함되지도 않으면 stkike도 ball도 아니다")
    @Test
    void strikeAndBallTest() {

        // given
        BaseballNumberBundle origin = new BaseballNumberBundle(Arrays.asList(
                new BaseballNumber(7),
                new BaseballNumber(1),
                new BaseballNumber(3)
        ));

        BaseballNumber number = new BaseballNumber(4);

        // when
        boolean isStrike = origin.isStrike(0, number);
        boolean isBall = origin.isBall(0, number);

        // then
        assertFalse(isStrike);
        assertFalse(isBall);
    }
}