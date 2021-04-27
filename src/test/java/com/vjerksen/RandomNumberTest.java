package com.vjerksen;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {

    // given
    private RandomNumber randomNumber = new RandomNumber();


    @DisplayName(value = "랜덤 숫자 생성 확인")
    @Test
    public void generateNumberTest() throws Exception {
        // when
        String number1 = randomNumber.generateNumber();
        String number2 = randomNumber.generateNumber();

        // then
        assertThat(number1).isNotEqualTo(number2);
    }

    @DisplayName(value = "전체적인 유효성 확인")
    @Test
    public void isValidateTest() {
        // when
        String number = randomNumber.generateNumber();
        boolean isValidate = randomNumber.isValidate(number);

        // then
        assertThat(isValidate).isTrue();
    }
}