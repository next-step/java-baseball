package com.vjerksen;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputNumberTest {

    @DisplayName(value = "숫자 입력받기")
    @Test
    public void getInputNumberTest() throws Exception {
        InputNumber inputNumber = new InputNumber();

        assertThat(inputNumber.generateNumber()).isEqualTo("123");
    }
}