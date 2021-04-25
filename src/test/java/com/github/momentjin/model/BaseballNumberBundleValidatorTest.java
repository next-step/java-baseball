package com.github.momentjin.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseballNumberBundleValidatorTest {

    private final BaseballNumberBundleValidator validator = new BaseballNumberBundleValidator();

    @DisplayName("BaseballNumberBundle은 크기가 3 미만이면 예외가 발생한다")
    @Test
    void testBundleSize() {

        // given
        List<BaseballNumber> baseballNumbers = Arrays.asList(
                new BaseballNumber(1),
                new BaseballNumber(2)
        );

        BaseballNumberBundle bundle = new BaseballNumberBundle(baseballNumbers);

        // when & then
        assertThrows(RuntimeException.class, () -> validator.validate(bundle));
    }

    @DisplayName("BaseballNumberBundle은 크기가 3 초과하면 예외가 발생한다")
    @Test
    void testBundleSize2() {

        // given
        List<BaseballNumber> baseballNumbers = Arrays.asList(
                new BaseballNumber(1),
                new BaseballNumber(2),
                new BaseballNumber(3),
                new BaseballNumber(4)
        );

        BaseballNumberBundle bundle = new BaseballNumberBundle(baseballNumbers);

        // when & then
        assertThrows(RuntimeException.class, () -> validator.validate(bundle));
    }

    @DisplayName("BaseballNumberBundle은 중복이 있으면 예외가 발생한다")
    @Test
    void testBundleOverLap() {

        // given
        List<BaseballNumber> baseballNumbers = Arrays.asList(
                new BaseballNumber(1),
                new BaseballNumber(2),
                new BaseballNumber(2)
        );

        BaseballNumberBundle bundle = new BaseballNumberBundle(baseballNumbers);

        // when & then
        assertThrows(RuntimeException.class, () -> validator.validate(bundle));
    }
}