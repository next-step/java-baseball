package com.vjerksen;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    Validation validation = new Validation();
    private String testString = "1a2";

    @DisplayName(value = "전체적인 유효성 확인")
    @Test
    public void isValidateTest() {
        assertThat(validation.isValidate(testString)).isTrue();
    }

    @DisplayName(value = "3자리 숫자 여부 확인")
    @Test
    public void chkLengthTest() {
        assertThat(validation.chkLength(testString)).isTrue();
    }

    @DisplayName(value = "숫자 간 중복여부 확인")
    @Test
    public void chkDuplicateTest() {
        assertThat(validation.chkDuplicate(testString)).isTrue();
    }

}