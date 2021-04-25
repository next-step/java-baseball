package com.github.momentjin.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorResultBundleTest {

    @DisplayName("하나라도 error이면 isError는 true를 반환한다")
    @Test
    void isError() {

        // given
        ValidatorResult fail = ValidatorResult.fail("");
        ValidatorResult success = ValidatorResult.success();

        ValidatorResultBundle bundle = new ValidatorResultBundle(
                Arrays.asList(fail, success)
        );

        // when
        boolean isError = bundle.isError();

        // then
        assertTrue(isError);
    }

    @DisplayName("모두 error가 아니면 isError는 false를 반환한다")
    @Test
    void isError2() {

        // given
        ValidatorResult success = ValidatorResult.success();
        ValidatorResult success2 = ValidatorResult.success();

        ValidatorResultBundle bundle = new ValidatorResultBundle(
                Arrays.asList(success, success2)
        );

        // when
        boolean isError = bundle.isError();

        // then
        assertFalse(isError);
    }
}