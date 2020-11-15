package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class StringUtilTest {

    @Test
    @DisplayName("\"1,2\" 스플릿으로 나누기")
    void req_1_1() {
        //given
        String target = "1,2";

        //when
        String[] array = target.split(",");

        //then
        assertThat(array).contains("1", "2");
    }

    @Test
    @DisplayName("\"1\" 스플릿으로 나누기")
    void req_1_2() {
        //given
        String target = "1";

        //when
        String[] array = target.split(",");

        //then
        assertThat(array).containsExactly("1");
    }

    @Test
    @DisplayName("()괄호 제거하기")
    void req_2() {
        //given
        String input = "(1,2)";
//        String input = "1,2)";
//        String input = "(1,2";
        String result = "";

        //when
        int indexOf_left_parentheses = input.indexOf("(") + 1;
        int indexOf_right_parentheses = input.lastIndexOf(")");
        if (indexOf_right_parentheses == -1)
            indexOf_right_parentheses = input.length();
        result = input.substring(indexOf_left_parentheses, indexOf_right_parentheses);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 확인")
    void req_3(){
        //given
        String input = "abc";
        int index = 4;


        //then
        assertThatThrownBy(() -> input.charAt(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(index);
                }).withMessageMatching("String index out of range: \\d+");
    }
}