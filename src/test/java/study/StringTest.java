package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @DisplayName("문자열 분리(구분자: ',')")
    @Test
    void requirement_01() {
        String input = "1,2";

        String[] result = input.split(",");

        assertThat(result)
                .contains("1")
                .contains("2")
                .containsExactly("1", "2");
    }

    @DisplayName("문자열 맨앞, 맨뒤 괄호제거")
    @Test
    void requirement_02() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 인덱스 범위(메세지 포함)")
    @Test
    void requirement_03_01() {
        String input = "abc";

        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> {
            input.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

    @DisplayName("charAt 인덱스 범위(메세지 매칭)")
    @Test
    void requirement_03_02() {
        String input = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(4);
                }).withMessageMatching("String index out of range: \\d+");
    }

}
