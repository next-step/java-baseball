package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("요구사항 1-1) 문자열 1,2를 , 로 split 했을 때 1과 2로 잘 분리되는지 확인한다.")
    void split1() {
        //given
        String string = "1,2";
        //when
        String[] array = string.split(",");
        //then
        assertThat(array).isNotEmpty().hasSize(2).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항 1-2) 문자열 1을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인한다.")
    void split2() {
        //given
        String string = "1";
        //when
        String[] array = string.split(",");
        //then
        assertThat(array).isNotEmpty().hasSize(1).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2) \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환하도록 한다")
    void substring() {
        //given
        String string = "(1,2)";
        //when
        String subString = string.substring(1, string.length() - 1);
        //then
        assertThat(subString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3-1) \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다")
    void charAt() {
        //given
        String string = "abc";
        //when
        char actualChar = string.charAt(0);
        //then
        assertThat(actualChar).isEqualTo('a');
    }

    @Test
    @DisplayName("요구사항 3-2) String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어날때 StringIndexOutOfBoundsException 를 확인한다")
    void charAtOutOfRange() {
        //given
        String string = "abc";

        assertThatThrownBy(() -> {
            string.charAt(string.length());
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("index out of range: " + string.length());
    }

}