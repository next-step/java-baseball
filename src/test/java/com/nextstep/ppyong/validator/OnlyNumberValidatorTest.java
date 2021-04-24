package com.nextstep.ppyong.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OnlyNumberValidatorTest {

    @Test
    @DisplayName("문자열이 섞인 숫자 예외 발생 성공 테스트")
    void duplicateNumberExceptionTest() {
        OnlyNumberValidator validator = new OnlyNumberValidator();
        assertThatThrownBy(() -> {
            validator.valid("A12");
        }).isInstanceOf(RuntimeException.class).hasMessageContaining("유효한 숫자가 아닙니다. 1-9의 '3자리' 정수를 입력해주세요.");
    }

    @Test
    @DisplayName("정상 숫자 통과 테스트")
    void onlyNumberTest() {
        OnlyNumberValidator validator = new OnlyNumberValidator();
        assertTrue(validator.valid("123"));
    }
}
