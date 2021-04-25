package com.github.momentjin.service;

import com.github.momentjin.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseballNumberBundleMatcherTest {

    private final BaseballNumberBundleMatcher service = new BaseballNumberBundleMatcher(new NoOpValidator());

    @DisplayName("정답이 713일 떄, 입력이 213이면 2S 0B")
    @Test
    void matchTest1() {

        BaseballNumberBundle origin = new BaseballNumberBundle(Arrays.asList(
                new BaseballNumber(7),
                new BaseballNumber(1),
                new BaseballNumber(3)
        ));

        BaseballNumberBundle target = new BaseballNumberBundle(Arrays.asList(
                new BaseballNumber(2),
                new BaseballNumber(1),
                new BaseballNumber(3)
        ));

        BaseballNumberMatchResult result = service.match(origin, target);

        // then
        assertEquals(2, result.getStrikeCount());
        assertEquals(0, result.getBallCount());
    }

    @DisplayName("정답이 713일 떄, 입력이 713이면 3S")
    @Test
    void matchTest2() {

        BaseballNumberBundle origin = new BaseballNumberBundle(Arrays.asList(
                new BaseballNumber(7),
                new BaseballNumber(1),
                new BaseballNumber(3)
        ));

        BaseballNumberBundle target = new BaseballNumberBundle(Arrays.asList(
                new BaseballNumber(7),
                new BaseballNumber(1),
                new BaseballNumber(3)
        ));

        BaseballNumberMatchResult result = service.match(origin, target);

        // then
        assertEquals(3, result.getStrikeCount());
        assertEquals(0, result.getBallCount());
    }

    @DisplayName("정답이 713일 떄, 입력이 137이면 0S 3B")
    @Test
    void matchTest3() {

        BaseballNumberBundle origin = new BaseballNumberBundle(Arrays.asList(
                new BaseballNumber(7),
                new BaseballNumber(1),
                new BaseballNumber(3)
        ));

        BaseballNumberBundle target = new BaseballNumberBundle(Arrays.asList(
                new BaseballNumber(1),
                new BaseballNumber(3),
                new BaseballNumber(7)
        ));

        BaseballNumberMatchResult result = service.match(origin, target);

        // then
        assertEquals(0, result.getStrikeCount());
        assertEquals(3, result.getBallCount());
    }
}

class NoOpValidator implements BaseballNumberBundleValidator {

    @Override
    public void validate(BaseballNumberBundle bundle) throws BaseballNumberDomainException {
        // do nothing
    }
}