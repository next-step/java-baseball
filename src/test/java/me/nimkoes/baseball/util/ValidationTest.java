package me.nimkoes.baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    @DisplayName("입력한 값이 숫자로만 이루어졌는지 확인")
    void checkNumberData() {
        // given
        String testValue1 = "1234";
        String testValue2 = "ab12";
        String testValue3 = "abcd";

        // then
        assertThat(Validation.checkNumberData(testValue1)).isTrue();
        assertThat(Validation.checkNumberData(testValue2)).isFalse();
        assertThat(Validation.checkNumberData(testValue3)).isFalse();
    }

    @Test
    @DisplayName("입력한 값의 길이가 난수의 길이와 같은지 확인")
    void checkNumberLength() {
        // given
        final int LENGTH_OF_NUMBER = 3;

        String testValue1 = "1";
        String testValue2 = "12";
        String testValue3 = "123";
        String testValue4 = "1234";


        // then
        assertThat(Validation.checkNumberLength(testValue1, LENGTH_OF_NUMBER)).isFalse();
        assertThat(Validation.checkNumberLength(testValue2, LENGTH_OF_NUMBER)).isFalse();
        assertThat(Validation.checkNumberLength(testValue3, LENGTH_OF_NUMBER)).isTrue();
        assertThat(Validation.checkNumberLength(testValue4, LENGTH_OF_NUMBER)).isFalse();

    }

    @Test
    @DisplayName("서로 다른 숫자로 이루어졌는지 확인")
    void checkDuplicateNumber() {
        // given
        String testValue1 = "12345";
        String testValue2 = "11234";

        // then
        assertThat(Validation.checkContainDuplicateNumber(testValue1)).isFalse();
        assertThat(Validation.checkContainDuplicateNumber(testValue2)).isTrue();
    }

    @Test
    @DisplayName("새 게임 시작 여부 판단을 위한 값으로 유효한 값을 입력했는지 확인")
    void checkEndingValue() {
        // given
        String testValue1 = "";
        String testValue2 = "1";
        String testValue3 = "2";
        String testValue4 = "3";

        // then
        assertThat(Validation.checkEndingValue(testValue1)).isFalse();
        assertThat(Validation.checkEndingValue(testValue2)).isTrue();
        assertThat(Validation.checkEndingValue(testValue3)).isTrue();
        assertThat(Validation.checkEndingValue(testValue4)).isFalse();
    }

}
