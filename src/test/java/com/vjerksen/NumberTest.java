package com.vjerksen;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

    @DisplayName(value = "랜덤 숫자 생성 확인")
    @Test
    public void getRandomNumberTest() throws Exception {
        Number number1 = new Number();
        Number number2 = new Number();

        assertThat(number1.getRandomNumber()).isNotEqualTo(number2.getRandomNumber());
    }

    @DisplayName(value = "숫자 입력받기")
    @Test
    public void getInputNumberTest() throws Exception {
        Number number1 = new Number();

        assertThat(number1.getInputNumber()).isEqualTo("123");
    }
}