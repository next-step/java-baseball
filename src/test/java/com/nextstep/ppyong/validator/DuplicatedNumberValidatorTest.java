package com.nextstep.ppyong.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class DuplicatedNumberValidatorTest {

    @Test
    @DisplayName("중복 숫자 예외 발생 성공 테스트")
    void duplicateNumberExceptionTest() {
        DuplicatedNumberValidator validator = new DuplicatedNumberValidator();
        assertThatThrownBy(() -> {
            validator.valid("112");
        }).isInstanceOf(RuntimeException.class).hasMessageContaining("유효한 숫자가 아닙니다. 1-9의 '3자리' 정수를 입력해주세요.");
    }

    @Test
    @DisplayName("중복 숫자 아닐 경우 정상 통과 테스트")
    void duplicateNumberTest() {
        DuplicatedNumberValidator validator = new DuplicatedNumberValidator();
        assertTrue(validator.valid("123"));
    }
}
