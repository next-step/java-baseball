package com.vjerksen;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    // given
    private Validation validation = new Validation();
    private String testString = "123";


    @DisplayName(value = "3자리 숫자 여부 확인")
    @Test
    public void chkLengthTest() {
        // when
        boolean chkLength = validation.chkLength(testString);

        // then
        assertThat(chkLength).isTrue();
    }

    @DisplayName(value = "숫자 간 중복여부 확인")
    @Test
    public void chkDuplicationTest() {
        // when
        boolean chkDuplication = validation.chkDuplication(testString);

        // then
        assertThat(chkDuplication).isTrue();
    }

}