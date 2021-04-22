package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("\"1,2\" 을 , 로 split 했을 때 1 과 2 로 잘 분리되는지 테스트")
    @Test
    void test_split_contains() {
        assertThat("1,2".split(",")).contains("1", "2");
    }

    @DisplayName("1\" 을 , 로 split 했을 때 1 만을 포함하는 배열이 반환되는지 테스트")
    @Test
    void test_split_containsExactly() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String 의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\" 를 반환하는지 테스트")
    @Test
    void test_substring() {
        String input = "(1,2)";
        String output = "(1,2)".substring(input.indexOf("(") + 1, input.indexOf(")"));
        assertThat(output).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 테스트")
    @Test
    void test_charAt() {
        String str = "abc";
        char[] inputArray = str.toCharArray();
        int length = inputArray.length;
        for (int i = 0; i < length; i++) {
            assertThat(str.charAt(i)).isEqualTo(inputArray[i]);
        }
    }

    @DisplayName("IndexOutOfBoundsException 테스트")
    @Test
    void test_IndexOutOfBoundsException() {
        String input = "abc";
        assertThatThrownBy(() -> {
            charAt(input);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    charAt(input);
                }).withMessageMatching("String index out of range: 5");
    }

    private void charAt(String input) {
        input.charAt(5);
    }
}
