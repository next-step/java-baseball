package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringTestTest {


    @Test
    @DisplayName("2개이상 문자열 comma(,) 분리 테스트")
    void divideTwoMoreCommaTest(){
        //given
        StringTest strTest = new StringTest();
        String givenText ="1,2";
        //when
        String[] strings = strTest.divideComma(givenText);
        //then
        assertThat(strings).as("문자열 \"1,2\"를 comma로 분리하기").contains("1","2");
    }

    @Test
    @DisplayName("1개 문자열 comma(,) 분리 테스트")
    void divideOnlyOneCommaTest(){
        //given
        StringTest strTest = new StringTest();
        String givenText ="1";
        //when
        String[] strings = strTest.divideComma(givenText);
        //then
        assertThat(strings).as("문자열 \"1\"를 comma로 분리하기").contains("1");
    }


    @Test
    @DisplayName("(1,2)에서 ()괄호 없애기")
    void removeParenthesisTest(){
        //given
        StringTest strTest = new StringTest();
        String givenText = "(1,2)";
        //when
        String result = strTest.removeParenthesis(givenText);
        //then
        assertThat(result).as("(1,2) -> 1,2로 변환").isEqualTo("1,2");
    }

}