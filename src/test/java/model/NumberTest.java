package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @Test
    @DisplayName("number 객체가 같은 값일 때 성공")
    void testEquals() {
        //given
        Number number = new Number("1");
        Number number2 = new Number("1");

        //when then
        assertThat(number.equals(number2)).isTrue();
    }
}