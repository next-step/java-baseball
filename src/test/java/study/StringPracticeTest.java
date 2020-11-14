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
        String givenText ="1,2";
        //when
        String[] strings = strTest.divideComma(givenText);
        //then
        assertThat(strings).as("문자열 \"1,2\"를 comma로 분리하기").contains("1","2");
    }

    @Test
    @DisplayName("2개이상 문자열 comma(,) 분리 테스트,정확한 순서도 학인 테스트")
    void divideTwoMoreCommaExactlyTest(){
        //given
        StringPractice strTest = new StringPractice();
        String givenText ="1,2";
        //when
        String[] strings = strTest.divideComma(givenText);
        //then
        assertThat(strings).as("문자열 \"1,2\"를 comma로 분리하기").containsExactly("1","2");
    }

    @Test
    @DisplayName("1개 문자열 comma(,) 분리 테스트")
    void divideOnlyOneCommaTest(){
        //given
        StringPractice strTest = new StringPractice();
        String givenText ="1";
        //when
        String[] strings = strTest.divideComma(givenText);
        //then
        assertThat(strings).as("문자열 \"1\"를 comma로 분리하기").contains("1");
    }

    @Test
    @DisplayName("1개 문자열 comma(,) 분리 테스트,정확한 순서도 학인 테스트")
    void divideOnlyOneCommaExactlyTest(){
        //given
        StringPractice strTest = new StringPractice();
        String givenText ="1";
        //when
        String[] strings = strTest.divideComma(givenText);
        //then
        assertThat(strings).as("문자열 \"1\"를 comma로 분리하기").containsExactly("1");
    }


    @Test
    @DisplayName("(1,2)에서 ()괄호 없애기")
    void removeParenthesisTest(){
        //given
        StringPractice strTest = new StringPractice();
        String givenText = "(1,2)";
        //when
        String result = strTest.removeParenthesis(givenText);
        //then
        assertThat(result).as("(1,2) -> 1,2로 변환").isEqualTo("1,2");
    }


    @Test
    @DisplayName("abc에서 특정문자 가져오기")
    void getFindCharTest(){
        //given
        StringPractice strTest = new StringPractice();
        String givenText = "abc";
        int index = 4;
        //when
        assertThatThrownBy(()->{
            try {
                char ch = strTest.getFindChar(index);
            }catch(IndexOutOfBoundsException e){
                throw new IndexOutOfBoundsException("Index: 4, Size: 3");
            }
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 4, Size: 3");
        //then
    }

    @Test
    @DisplayName("abc에서 특정문자 가져오기(에러메시지 숫자타입 체크")
    void getFindCharExactlyTest(){
        //given
        StringPractice strTest = new StringPractice();
        String givenText = "abc";
        int index = 4;
        //when
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(()-> {
            try {
                char ch = strTest.getFindChar(index);
            }catch(IndexOutOfBoundsException e){
                throw new IndexOutOfBoundsException("Index: 4, Size: 3");
            }
        }).withMessageMatching("Index: \\d+, Size: \\d+");
    }

}