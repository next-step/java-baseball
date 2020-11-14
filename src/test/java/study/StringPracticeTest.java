package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringPracticeTest {


    @Test
    @DisplayName("2개이상 문자열 comma(,) 분리 테스트")
    void divideTwoMoreCommaTest(){
        //given
        StringPractice strTest = new StringPractice();
        java.lang.String givenText ="1,2";
        //when
        java.lang.String[] strings = strTest.divideComma(givenText);
        //then
        assertThat(strings).as("문자열 \"1,2\"를 comma로 분리하기").contains("1","2");
    }

    @Test
    @DisplayName("1개 문자열 comma(,) 분리 테스트")
    void divideOnlyOneCommaTest(){
        //given
        StringPractice strTest = new StringPractice();
        java.lang.String givenText ="1";
        //when
        java.lang.String[] strings = strTest.divideComma(givenText);
        //then
        assertThat(strings).as("문자열 \"1\"를 comma로 분리하기").contains("1");
    }


    @Test
    @DisplayName("(1,2)에서 ()괄호 없애기")
    void removeParenthesisTest(){
        //given
        StringPractice strTest = new StringPractice();
        java.lang.String givenText = "(1,2)";
        //when
        java.lang.String result = strTest.removeParenthesis(givenText);
        //then
        assertThat(result).as("(1,2) -> 1,2로 변환").isEqualTo("1,2");
    }

}