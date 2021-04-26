package com.vjerksen;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {

    @DisplayName(value = "랜덤 숫자 생성 확인")
    @Test
    public void getRandomNumberTest() throws Exception {
        RandomNumber randomNumber1 = new RandomNumber();
        RandomNumber randomNumber2 = new RandomNumber();

        assertThat(randomNumber1.generateNumber()).isNotEqualTo(randomNumber2.generateNumber());
    }

}