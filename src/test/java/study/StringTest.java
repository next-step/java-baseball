package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {
    @Test
    void stringSplit() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).contains("1", "2");

        input = "1";
        result = input.split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void stringSubstring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("OutOfBoundsException 테스트")
    void stringChatAt() {
        assertThatThrownBy(() -> {
            String input = "abc";
            input.charAt(input.length()+1);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");

    }


}